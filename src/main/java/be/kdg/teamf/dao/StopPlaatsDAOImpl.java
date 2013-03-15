package be.kdg.teamf.dao;

import be.kdg.teamf.model.StopPlaats;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class StopPlaatsDAOImpl implements StopPlaatsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStopPlaats(StopPlaats stopPlaats) {
        sessionFactory.getCurrentSession().save(stopPlaats);
    }

    @Override
    public void updateStopPlaats(StopPlaats stopPlaats) {
        sessionFactory.getCurrentSession().update(stopPlaats);
    }

    @Override
    public void deleteStopPlaats(StopPlaats stopPlaats) {
        sessionFactory.getCurrentSession().delete(stopPlaats);
    }

    @Override
    public StopPlaats findStopPlaats(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from StopPlaats where stopPlaatsID = :id");
        q.setInteger("id", id);
        if(q.list().size() != 0){
        return (StopPlaats) q.list().get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public List<StopPlaats> getStopplaatsenByTrip(int tripID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from StopPlaats where trip = :id");
        q.setInteger("id", tripID);
        return q.list();
    }



}
