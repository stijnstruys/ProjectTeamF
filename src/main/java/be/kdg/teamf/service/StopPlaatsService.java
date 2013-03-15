package be.kdg.teamf.service;

import be.kdg.teamf.model.StopPlaats;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */

public interface StopPlaatsService {
    public void addStopPlaats(StopPlaats stopPlaats);
    public void updateStopPlaats (StopPlaats stopPlaats);
    public void deleteStopPlaats (StopPlaats stopPlaats);
    public StopPlaats findStopPlaats(int stopPlaatsID);
    public boolean controleerAntwoord(String antwoord, StopPlaats sp);
    public List<StopPlaats> getStopPlaatsenByTripId(int tripId);

}
