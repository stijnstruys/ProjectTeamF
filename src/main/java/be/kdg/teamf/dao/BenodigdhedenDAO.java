package be.kdg.teamf.dao;

import be.kdg.teamf.model.Benodigdheid;
import be.kdg.teamf.model.Deelname;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 20/02/13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public interface BenodigdhedenDAO  {
    public void addBenodigdheid(Benodigdheid benodigdheid);
    public void updateBenodigdheid(Benodigdheid benodigdheid);
    public void deleteBenodigdheid(Benodigdheid benodigdheid);
    Deelname findBenodigdheid(int benodigdheidID);
}
