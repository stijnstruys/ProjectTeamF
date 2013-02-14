package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class DeelnameDAOImpl implements DeelnameDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addDeelname(Deelname deelname) {
        sessionFactory.getCurrentSession().save(deelname);
    }

    @Override
    public void updateDeelname(Deelname deelname) {
        sessionFactory.getCurrentSession().update(deelname);
    }

    @Override
    public void deleteDeelname(Deelname deelname) {
        sessionFactory.getCurrentSession().delete(deelname);
    }

    @Override
    public Deelname findDeelname(int deelnameID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Deelname where deelnameID = :deelnameID");
        q.setInteger("deelnameID", deelnameID);
        return (Deelname) q.list().get(0);
    }
}
