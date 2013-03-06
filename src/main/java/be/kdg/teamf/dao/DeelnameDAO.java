package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;

import java.util.ArrayList;

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

    Deelname findDeelname(int deelnameID);

    Deelname findDeelname(int tripId, int userID);

    ArrayList<Deelname> findDeelnames(Trip t);
    ArrayList<Deelname> findDeelnamesByUser(User u);

}
