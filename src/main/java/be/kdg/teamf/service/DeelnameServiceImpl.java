package be.kdg.teamf.service;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeelnameServiceImpl implements DeelnameService {

    @Autowired
    private DeelnameDAO deelnameDAO;

    @Override
    @Transactional
    public void addDeelname(Deelname deelname) {
        deelnameDAO.addDeelname(deelname);
    }

    @Override
    @Transactional
    public void updateDeelname(Deelname deelname) {
        deelnameDAO.updateDeelname(deelname);
    }

    @Override
    @Transactional
    public void deleteDeelname(Deelname deelname) {
        deelnameDAO.deleteDeelname(deelname);
    }

    @Override
    @Transactional
    public Deelname findDeelname(int deelnameID) {
        return deelnameDAO.findDeelname(deelnameID);
    }

    @Override
    @Transactional
    public boolean alreadyExists(Deelname dNew) {


        Deelname origineel = deelnameDAO.findDeelname(dNew.getTrip().getTripId(), dNew.getUser().getUserID());

        if(origineel != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    @Transactional
    public boolean userIsRegistered(Trip t, User u) {

        if(deelnameDAO.findDeelname(t.getTripId(),u.getUserID()) != null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    @Transactional
    public Deelname findDeelname(Trip t, User u) {
        return deelnameDAO.findDeelname(t.getTripId(),u.getUserID());
    }

    @Override
    @Transactional
    public ArrayList<Deelname> getDeelnamesByTrip(Trip t) {
        return deelnameDAO.findDeelnames(t);
    }

    @Override
    @Transactional
    public ArrayList<Deelname> getDeelnamesByUser(User u) {
        return deelnameDAO.findDeelnamesByUser(u);
    }
}
