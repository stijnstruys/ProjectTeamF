package be.kdg.teamf.service;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public interface DeelnameService {
    public void addDeelname(Deelname deelname);

    public void updateDeelname(Deelname deelname);

    public void deleteDeelname(Deelname deelname);

    public  Deelname findDeelname(int deelnameID);

    boolean alreadyExists(Deelname d);

    boolean userIsRegistered(Trip t, User u);

    public Deelname findDeelname(Trip t, User u);

    public ArrayList<Deelname> getDeelnamesByTrip(Trip t);

    public ArrayList<Deelname> getDeelnamesByUser(User u);

}
