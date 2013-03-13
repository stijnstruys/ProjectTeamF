package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeelnameDAOImpl implements DeelnameDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
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
        if(q.list().size() > 0){
            return (Deelname) q.list().get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public Deelname findDeelname(int tripId, int userID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Deelname where trip.tripId = :tripId and user.userID = :userId");
        q.setInteger("tripId", tripId);
        q.setInteger("userId", userID);
        if(q.list().size() > 0){
            return (Deelname) q.list().get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public ArrayList<Deelname> findDeelnames(Trip t) {

        Query q = sessionFactory.getCurrentSession().createQuery("from Deelname where trip.tripId = :tripId");
        q.setInteger("tripId", t.getTripId());

        return (ArrayList<Deelname>) q.list();
    }

    @Override
    public ArrayList<Deelname> findDeelnamesByUser(User u) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Deelname where user.userID = :userId");
        q.setInteger("userId", u.getUserID());

        return (ArrayList<Deelname>) q.list();
    }
}
