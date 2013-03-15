package be.kdg.teamf.dao;

import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public interface KostDAO {
    public void addKost(Kost kost);
    public void updateKost(Kost kost);
    public void deleteKost(Kost kost);
    public List<Kost> kostenPerUser(User u);
    public List<Kost> kostenPerTrip(Trip t);
    public List<Kost> kostenPerTripEnUser(Trip t, User u);

    public Kost findKost(int kostId);
}
