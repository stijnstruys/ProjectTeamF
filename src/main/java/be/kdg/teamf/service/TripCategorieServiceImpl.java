package be.kdg.teamf.service;

import be.kdg.teamf.dao.TripCategorieDAO;
import be.kdg.teamf.model.TripCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */

@Service
public class TripCategorieServiceImpl implements TripCategorieService {

    @Autowired
    private TripCategorieDAO tripCategorieDAO;

    @Transactional
    public void addTripCategorie(TripCategorie tripCategorie) {
        tripCategorieDAO.addTripCategorie(tripCategorie);
    }

    @Override
    @Transactional
    public void updateTripCategorie(TripCategorie tripCategorie) {
        tripCategorieDAO.updateTripCategorie(tripCategorie);
    }

    @Transactional
    public void removeTripCategorie(TripCategorie tripCategorie) {
        tripCategorieDAO.removeTripCategorie(tripCategorie);
    }

    @Override
    public TripCategorie getTripCategories(int tripID) {
       return tripCategorieDAO.getTripCategories(tripID);
    }

    @Override
    public TripCategorie findTripCategorie(int tripCategorieId) {
        return tripCategorieDAO.findTripCategorie(tripCategorieId);
    }
}
