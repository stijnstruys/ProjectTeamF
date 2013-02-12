package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripCategorie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class TripCategorieDAOImpl implements TripCategorieDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTripCategorie(TripCategorie tripCategorie) {
        sessionFactory.getCurrentSession().save(tripCategorie);
    }

    @Override
    public void updateTripCategorie(TripCategorie tripCategorie) {
        sessionFactory.getCurrentSession().update(tripCategorie);
    }

    @Override
    public void removeTripCategorie(int id) {
        TripCategorie tripCat = (TripCategorie) sessionFactory.getCurrentSession().load(TripCategorie.class, id);
        if(tripCat != null)
        {
            sessionFactory.getCurrentSession().delete(tripCat);
        }
    }
}
