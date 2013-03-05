package be.kdg.teamf.dao;

import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class KostenDAOImpl implements KostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addKost(Kost kost) {
        sessionFactory.getCurrentSession().save(kost);
    }

    @Override
    public void deleteKost(Kost kost) {
        sessionFactory.getCurrentSession().delete(kost);
    }

    @Override
    public List<Kost> kostenPerUser(User u) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Kost where user.userID = :id");
        q.setInteger("id", u.getUserID());
        return q.list();
    }

    @Override
    public List<Kost> kostenPerTrip(Trip t) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Kost where trip.tripId = :id");
        q.setInteger("id", t.getTripId());
        return q.list();
    }

    @Override
    public List<Kost> kostenPerTripEnUser(Trip t, User u) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Kost where trip.tripId = :tripId and user.userID = :userId");
        q.setInteger("tripId", t.getTripId());
        q.setInteger("userId", u.getUserID());
        return q.list();
    }
}
