package be.kdg.teamf.service;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDAO tripDAO;
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    @Transactional
    public void addTrip(Trip trip) {
        tripDAO.addTrip(trip);
    }

    @Transactional
    public void updateTrip(Trip trip) {
        tripDAO.updateTrip(trip);
    }

    @Transactional
    public void deleteTrip(int id) {
        tripDAO.removeTrip(id);
    }

    @Transactional
    public List<Trip> listTrips() {
        return tripDAO.listTrips();
    }

    @Transactional
    public Trip findTrip(int tripID) {
        return tripDAO.findTrip(tripID);
    }

    @Transactional
    public List<Trip> searchTrips(String searchInput) {
        return tripDAO.searchTrips(searchInput);
    }

    @Transactional
    public List<String> getTripNames() {
        return tripDAO.getTripNames();
    }


    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }


    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendMail(String receiver, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

    }
}
