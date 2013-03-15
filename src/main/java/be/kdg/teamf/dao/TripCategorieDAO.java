package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripCategorie;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 13/02/13
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public interface TripCategorieDAO {
    public void addTripCategorie(TripCategorie tripCategorie);
    public void updateTripCategorie(TripCategorie tripCategorie);
    public void removeTripCategorie(TripCategorie tripCategorie);
    public List<TripCategorie> getTripCategories(int tripID);
    public TripCategorie findTripCategorie(int tripCategorieID);
}
