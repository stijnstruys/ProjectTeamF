package be.kdg.teamf.service;

import be.kdg.teamf.model.StopPlaats;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public interface StopPlaatsService {
    public  void addStopPlaats(StopPlaats stopPlaats);
    public void updateStopPlaats (StopPlaats stopPlaats);
    public void deleteStopPlaats (StopPlaats stopPlaats);

    StopPlaats findStopPlaats(int stopPlaatsID);
}