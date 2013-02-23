package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripCategorie;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class TripCategorieDAOImpl implements TripCategorieDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addTripCategorie(TripCategorie tripCategorie) {
        sessionFactory.getCurrentSession().save(tripCategorie);
    }

    @Override
    public void updateTripCategorie(TripCategorie tripCategorie) {
        sessionFactory.getCurrentSession().update(tripCategorie);
    }

    @Override
    public void removeTripCategorie(TripCategorie tripCategorie) {
            sessionFactory.getCurrentSession().delete(tripCategorie);
    }

    @Override
    public TripCategorie getTripCategories(int tripID) {

        Query q = sessionFactory.getCurrentSession().createQuery("from TripCategorie where trip = :tripId");
        q.setInteger("tripId", tripID);
        return (TripCategorie) q.list().get(0);
    }

    @Override
    public TripCategorie findTripCategorie(int tripCategorieId) {
        Query q = sessionFactory.getCurrentSession().createQuery("from TripCategorie where tripCategorieId = :tripCategorieId");
        q.setInteger("tripCategorieId", tripCategorieId);
        return (TripCategorie) q.list().get(0);
    }
}
