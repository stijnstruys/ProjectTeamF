package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class TripTypeDAOImpl implements TripTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTripType(TripType tripType) {
        sessionFactory.getCurrentSession().save(tripType);
    }

    @Override
    public void updateTripType(TripType tripType) {
        sessionFactory.getCurrentSession().update(tripType);
    }

    @Override
    public void removeTripType(int id) {
        TripType tripType = (TripType) sessionFactory.getCurrentSession().load(TripType.class, id);
        if(tripType != null)
        {
            sessionFactory.getCurrentSession().delete(tripType);
        }
    }
}
