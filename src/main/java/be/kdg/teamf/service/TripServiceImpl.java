package be.kdg.teamf.service;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
    private VelocityEngine velocityEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Transactional
    public void addTrip(Trip trip) {
        tripDAO.addTrip(trip);
    }

    @Override
    @Transactional
    public void updateTrip(Trip trip) {
        tripDAO.updateTrip(trip);
    }

    @Override
    @Transactional
    public void deleteTrip(int id) {
        tripDAO.removeTrip(id);
    }

    @Override
    @Transactional
    public List<Trip> listTrips() {
        return tripDAO.listTrips();
    }

    @Override
    @Transactional
    public Trip findTrip(int tripID) {
        return tripDAO.findTrip(tripID);
    }

    @Override
    @Transactional
    public List<Trip> searchTrips(String searchInput) {
        return tripDAO.searchTrips(searchInput);
    }

    @Override
    @Transactional
    public List<Trip> listUserTrips(int userID) {
        return tripDAO.listUserTrips(userID);
    }

    @Override
    @Async
    public void sendMail(final ModelMap model, final SimpleMailMessage msg) {
        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage)
                    throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setCc(msg.getCc());
                message.setFrom(msg.getFrom());
                message.setSubject(msg.getSubject());
                //template uit resources halen en invullen
                String body = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "/mailTripUpdate.vm", model);
                message.setText(body, true);

                message.addInline("header", new ClassPathResource(
                        "images/header.jpg"));
            }
        });
    }

    @Override
    @Transactional
    public boolean checkOwnership(Trip t, User u) {

        return t.getOrganiser().getUserID() == u.getUserID();
    }

    @Override
    @Transactional
    public List<Trip> listUserParticipateTrips(int UserID) {
        return tripDAO.listUserParticipateTrips(UserID);
    }

    @Override
    @Async
    public void sendInvite(final ModelMap model, final SimpleMailMessage msg) {

        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage)
                    throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setTo(msg.getTo());
                message.setFrom(msg.getFrom());
                message.setSubject(msg.getSubject());

                //template uit resources halen en invullen
                String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/invite.vm", model);
                message.setText(body, true);

                message.addInline("header", new ClassPathResource(
                        "images/header.jpg"));
            }
        });
    }

    @Override
    @Transactional
    public List<Trip> listPublicTrips() {
        return tripDAO.listPublicTrips();
    }

    @Override
    @Transactional
    public List<Trip> searchTripsCategories(String searchInput) {

        return tripDAO.searchTripsCategories(searchInput);

    }

    @Override
    @Transactional
    public List<String> listUserEmailPerTrips(int tripID) {
        return tripDAO.listUserEmailPerTrips(tripID);
    }


}
