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
public class TripDAOImpl implements TripDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTrip(Trip trip) {
        sessionFactory.getCurrentSession().save(trip);
    }

    @Override
    public void updateTrip(Trip trip) {
        sessionFactory.getCurrentSession().update(trip);
    }

    @Override
    public void removeTrip(int id) {
        Trip trip = findTrip(id);
        if (trip != null) {
            sessionFactory.getCurrentSession().delete(trip);
        }
    }

    @Override
    public List<Trip> listTrips() {
        return sessionFactory.getCurrentSession().createQuery("from Trip").list();
    }

    @Override
    public List<Trip> searchTrips(String searchInput) {
        String si = "%" + searchInput + "%";
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where tripName like :si and (endDate > current_date or tripType = :los) order by tripId desc");
        q.setString("si", si);
        q.setString("los", "Los");
        return q.list();
    }

    @Override
    public Trip findTrip(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where tripId = :id  order by tripId desc");
        q.setInteger("id", id);
        if(q.list().size() == 0){
            return null;
        }
        return (Trip) q.list().get(0);
    }

    @Override
    public List<Trip> listUserTrips(int userID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where organiser = :id order by tripId desc ");
        q.setInteger("id", userID);
        return q.list();
    }

    @Override
    public List<Trip> listUserParticipateTrips(int userID) {
        Query q = sessionFactory.getCurrentSession().createQuery("select t from Trip t, Deelname d where d.trip.tripId = t.tripId and d.user.userID = :id  order by tripId desc");
        q.setInteger("id", userID);
        return q.list();
    }




    @Override
    public List<Trip> listPublicTrips() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Trip where visible = true  and (endDate > current_date or tripType = :los)  order by tripId desc");
        q.setString("los", "Los");
        return q.list();
    }

    @Override
    public List<String> listUserEmailPerTrips(int tripID) {
        Query q = sessionFactory.getCurrentSession().createQuery("select u.email from User u where u.notificationEmail = true and u.userID in(select d.user from Deelname d where d.trip = :tripID) ");
        q.setInteger("tripID", tripID);
        return q.list();
    }

    @Override
    public List<Trip> searchTripsCategories(String searchInput) {

        String si = "%" + searchInput + "%";
        Query q = sessionFactory.getCurrentSession().createQuery("select t from Trip t , TripCategorie tc where tc.tripCategorieName like :si and tc.trip.tripId = t.tripId and (t.endDate > current_date or tripType = :los) order by tripId desc");
        q.setString("si", si);
        q.setString("los", "Los");
        return q.list();
    }
}
