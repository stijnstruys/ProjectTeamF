package be.kdg.teamf.service;

import be.kdg.teamf.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Trip;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDAO tripDAO;

    @Transactional
    public void addTrip(Trip trip) {
        tripDAO.addTrip(trip);
    }

    @Transactional
    public void updateTrip(Trip trip) {
        tripDAO.updateTrip(trip);
    }

    @Transactional
    public void removeTrip(int id) {
        tripDAO.removeTrip(id);
    }
}
