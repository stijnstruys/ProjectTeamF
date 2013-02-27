package be.kdg.teamf.service;

import be.kdg.teamf.model.TripType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 13/02/13
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
public interface TripTypeService {
    public void addTripType(TripType tripType);
    public void updateTripType(TripType tripType);
    public void removeTripType(TripType tripType);
    public List<TripType> listTripTypes();
    public TripType findTripType(int tripTypeId);


}
