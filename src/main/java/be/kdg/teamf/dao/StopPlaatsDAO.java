package be.kdg.teamf.dao;

import be.kdg.teamf.model.StopPlaats;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */

public interface StopPlaatsDAO {

    public void addStopPlaats(StopPlaats stopPlaats);
    public void updateStopPlaats(StopPlaats stopPlaats);
    public void deleteStopPlaats(StopPlaats stopPlaats);
    public StopPlaats findStopPlaats(int stopPlaatsID);
    public List<StopPlaats> getStopplaatsenByTrip(int tripID);


}
