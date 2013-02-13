package be.kdg.teamf.dao;

import be.kdg.teamf.model.Trip;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        Trip trip = findTrip(id);
        if(trip != null)
        {
            sessionFactory.getCurrentSession().delete(trip);
        }
    }

    public List<Trip> listTrips() {
        return sessionFactory.getCurrentSession().createQuery("from Trip").list();
    }

    @Override
    public List<Trip> searchTrips(String searchInput) {
        String si = "%"+searchInput+"%";
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where tripName like :si");
        q.setString("si", si);
        return q.list();
    }

    public Trip findTrip(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where tripId = :id");
        q.setInteger("id",id);
        return (Trip) q.list().get(0);
    }

    @Override
    public List<String> getTripNames() {
        return sessionFactory.getCurrentSession().createQuery("select tripName from Trip").list();
    }


}
