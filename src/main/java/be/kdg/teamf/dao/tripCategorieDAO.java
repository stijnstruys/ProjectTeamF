package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripCategorie;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public interface TripCategorieDAO {
    public void addTripCategorie(TripCategorie tripCategorie);
    public void updateTripCategorie(TripCategorie tripCategorie);
    public void removeTripCategorie(int id);
}
