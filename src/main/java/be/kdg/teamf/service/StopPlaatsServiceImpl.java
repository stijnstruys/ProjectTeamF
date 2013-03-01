package be.kdg.teamf.service;

import be.kdg.teamf.dao.StopPlaatsDAO;
import be.kdg.teamf.model.StopPlaats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */

@Service
public class StopPlaatsServiceImpl implements StopPlaatsService {

    @Autowired
    private StopPlaatsDAO stopPlaatsDAO;

    @Transactional
    public void addStopPlaats(StopPlaats stopPlaats) {
        stopPlaatsDAO.addStopPlaats(stopPlaats);
    }

    @Override
    public void updateStopPlaats(StopPlaats stopPlaats) {
        stopPlaatsDAO.updateStopPlaats(stopPlaats);
    }

    @Override
    public void deleteStopPlaats(StopPlaats stopPlaats) {
        stopPlaatsDAO.deleteStopPlaats(stopPlaats);
    }

    @Override
    public StopPlaats findStopPlaats(int stopPlaatsID) {
        return stopPlaatsDAO.findStopPlaats(stopPlaatsID);
    }

    @Override
    public List<StopPlaats> listStopPlaatsen() {

     return stopPlaatsDAO.listStopPlaatsen();
    }

    @Override
    public boolean controleerAntwoord(String antwoord, StopPlaats sp) {
        return antwoord.equals(sp.getCorrectAntwoord());
    }

    @Override
    public List<StopPlaats> getStopPlaatsenByTripId(int tripId) {
        return stopPlaatsDAO.getStopplaatsenByTrip(tripId);
    }


}
