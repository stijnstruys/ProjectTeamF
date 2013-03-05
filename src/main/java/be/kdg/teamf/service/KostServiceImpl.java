package be.kdg.teamf.service;

import be.kdg.teamf.dao.KostDAO;
import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class KostServiceImpl implements KostService {
    @Autowired
    KostDAO kostDAO;

    @Override
    public void addKost(Kost kost) {
        kostDAO.addKost(kost);
    }

    @Override
    public void deleteKost(Kost kost) {
        kostDAO.deleteKost(kost);
    }

    @Override
    public List<Kost> kostenPerUser(User u) {
        return kostDAO.kostenPerUser(u);
    }

    @Override
    public List<Kost> kostenPerTrip(Trip t) {
        return kostDAO.kostenPerTrip(t);
    }

    @Override
    public List<Kost> kostenPerTripEnUser(Trip t, User u) {
        return kostDAO.kostenPerTripEnUser(t,u);
    }

    @Override
    public Kost findKost(int kostId) {
        return kostDAO.findKost(kostId);
    }
}
