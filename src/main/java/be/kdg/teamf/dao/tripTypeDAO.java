package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripType;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public interface TripTypeDAO {
    public void addTripType(TripType tripType);
    public void updateTripType(TripType tripType);
    public void removeTripType(int id);
}
