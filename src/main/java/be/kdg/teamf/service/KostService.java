package be.kdg.teamf.service;

import be.kdg.teamf.model.Kost;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public interface KostService {
    public void addKost(Kost kost);
    public void updateKost(Kost kost);
    public void deleteKost(Kost kost);


    public Kost findKost(int kostId);
}
