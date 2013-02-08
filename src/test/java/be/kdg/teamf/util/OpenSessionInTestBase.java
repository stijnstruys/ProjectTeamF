package be.kdg.teamf.util;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.transaction.support.TransactionSynchronizationManager;
/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 8-2-13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */


public abstract class OpenSessionInTestBase extends AbstractTransactionalDataSourceSpringContextTests {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Before
    protected void onSetUp() throws Exception {
        createHibernateSession();
        super.onSetUp();
    }

    @After
    protected void onTearDown() throws Exception {
        super.onTearDown();
        closeHibernateSession();
    }

    private void createHibernateSession() {
        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        session.setFlushMode(FlushMode.NEVER);
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
    }

    private void closeHibernateSession() {
        SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.closeSession(sessionHolder.getSession());
    }

}

