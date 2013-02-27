package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 13/02/13
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
public interface TripTypeDAO {
    public void addTripType(TripType tripType);
    public void updateTripType(TripType tripType);
    public List<TripType> listTripTypes();
    TripType findTripType(int tripTypeID);
    void removeTripType(TripType tripType);
}
