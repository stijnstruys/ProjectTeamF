package be.kdg.teamf.service;

import be.kdg.teamf.dao.TripTypeDAO;
import be.kdg.teamf.model.TripType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */

@Service
public class TripTypeServiceImpl implements TripTypeService {

    @Autowired
    private TripTypeDAO tripTypeDAO;

    @Transactional
    public void addTripType(TripType tripType) {
        tripTypeDAO.addTripType(tripType);
    }

    @Transactional
    public void updateTripType(TripType tripType) {
        tripTypeDAO.updateTripType(tripType);
    }

    @Transactional
    public void removeTripType(TripType tripType) {
        tripTypeDAO.removeTripType(tripType);
    }

    @Transactional
    public List<TripType> listTripTypes() {
        return tripTypeDAO.listTripTypes();
    }


    @Override
    public TripType findTripType(int TripTypeID) {
        return tripTypeDAO.findTripType(TripTypeID);
    }

    @Transactional
    public TripType findTripType(int tripTypeId) {
        return tripTypeDAO.findTripType(tripTypeId);
    }

}
