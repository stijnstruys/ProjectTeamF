package be.kdg.teamf.dao;

import be.kdg.teamf.model.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public interface TripDAO {

    public void addTrip(Trip trip);
    public void updateTrip(Trip trip);
    public void removeTrip(int id);

}
