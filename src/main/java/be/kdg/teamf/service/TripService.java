package be.kdg.teamf.service;

import be.kdg.teamf.model.Trip;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public interface TripService {

   public void addTrip(Trip trip);
   public void updateTrip(Trip trip);
   public void deleteTrip(int id);
}
