package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public interface DeelnameDAO {

    public void addDeelname(Deelname deelname);

    public void updateDeelname(Deelname deelname);

    public void deleteDeelname(Deelname deelname);

    public Deelname findDeelname(int deelnameID);

    public Deelname findDeelname(int tripId, int userID);

    public ArrayList<Deelname> findDeelnames(Trip t);
    public ArrayList<Deelname> findDeelnamesByUser(User u);

    public ArrayList<String> findPositions(int tripid, int userid);
}
