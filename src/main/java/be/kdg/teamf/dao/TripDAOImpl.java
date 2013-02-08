package be.kdg.teamf.dao;

import be.kdg.teamf.model.Trip;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class TripDAOImpl implements TripDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addTrip(Trip trip) {
        sessionFactory.getCurrentSession().save(trip);
    }

    public void updateTrip(Trip trip) {
        sessionFactory.getCurrentSession().update(trip);
    }

    public void removeTrip(int id) {
        Trip trip = (Trip) sessionFactory.getCurrentSession().load(Trip.class, id);
        if(trip != null)
        {
            sessionFactory.getCurrentSession().delete(trip);
        }
    }
}
