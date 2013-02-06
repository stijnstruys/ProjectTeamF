import Persistence.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 1-2-13
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public Test() {
    }
    //test
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        User u = new User("test","test","test","test","test","test","test","test","test","test","test");
        session.saveOrUpdate(u);
        tx.commit();


        System.out.println("blabla");
    }
}
