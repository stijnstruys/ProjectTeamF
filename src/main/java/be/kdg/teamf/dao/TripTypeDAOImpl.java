package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripType;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void removeTripType(TripType tripType) {

            sessionFactory.getCurrentSession().delete(tripType);

    }

    @Override
    public List<TripType> listTripTypes() {
        return sessionFactory.getCurrentSession().createQuery("from TripType").list();
    }

    @Override
    public TripType findTripType(int tripTypeID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from TripType where tripTypeId = :tripTypeID");
        q.setInteger("tripTypeID", tripTypeID);
        if (q.list().size() > 0) {
            return (TripType) q.list().get(0);
        } else {
            return null;
        }
    }
}
