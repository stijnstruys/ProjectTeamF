package be.kdg.teamf.service;

import be.kdg.teamf.model.Trip;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 7/02/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public interface TripService {

    public void addTrip(Trip trip);

    public void updateTrip(Trip trip);

    public void deleteTrip(int id);

    public List<Trip> listTrips();

    public Trip findTrip(int tripID);

    public List<Trip> searchTrips(String searchInput);

    public List<String> getTripNames();

    public List<Trip> listUserTrips(int userID);

    public void sendMail(final ModelMap model, final SimpleMailMessage msg);

}
