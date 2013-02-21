package be.kdg.teamf.service;

import be.kdg.teamf.model.Benodigdheid;
import be.kdg.teamf.model.Deelname;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 20/02/13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public interface BenodigdhedenService {
    public void addBenodigdheid(Benodigdheid benodigdheid);
    public void updateBenodigdheid(Benodigdheid benodigdheid);
    public void deleteBenodigdheid(Benodigdheid benodigdheid);
    Deelname findBenodigdheid(int benodigdheidID);
}
