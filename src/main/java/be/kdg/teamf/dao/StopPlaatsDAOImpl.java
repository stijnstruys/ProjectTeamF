package be.kdg.teamf.dao;

import be.kdg.teamf.model.StopPlaats;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
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
}
