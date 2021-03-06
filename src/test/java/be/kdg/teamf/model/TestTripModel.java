package be.kdg.teamf.model;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.service.TripService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 8/02/13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestTripModel {
     @Autowired
     protected TripDAO tripDAO;

    @Autowired
    protected TripService tripService;

    @Test
    public void addTrip() {
        Date d = new Date();
        Trip t = new Trip();
        User u = new User();
        List<Deelname> deelnameList = new ArrayList();
        List<StopPlaats> stopPlaatsList = new ArrayList();
        List<TripCategorie> tripCategorieList = new ArrayList();
        List<String> equipment = new ArrayList<>();
        List<Chat> chats = new ArrayList<>();
        List<BroadcastMessage> broadcastMessages = new ArrayList<>();
        equipment.add("equipment");

        t.setTripName("tripname");
        t.setEndDate(d);
        t.setOrganiser(u);
        t.setStartDate(d);
        t.setStartLocation("startlocation");
        t.setTripId(1);
        t.setTripDescription("beschrijving");
        t.setBgcolor("blue");
        t.setDeelnames(deelnameList);
        t.setFontcolorContent("red");
        t.setFontcolorTitle("green");
        t.setTripType("Tijdsgebonden");
        t.setStopPlaatsen(stopPlaatsList);
        t.setTripCategorieen(tripCategorieList);
        t.setNotification("notification");
        t.setEquipment(new ArrayList<String>());
        t.setEquipment(equipment);
        t.setVisible(true);
        t.setShowMap(true);
        t.setShowRoute(true);
        t.setTravelType("Driving");
        t.setChats(chats);
        t.setBroadcastMessages(broadcastMessages);
        assertEquals("Expected id: 1", 1, t.getTripId());
        assertEquals("Expected tripname: tripname", "tripname", t.getTripName());
        assertEquals("Enddate", d, t.getEndDate());
        assertEquals("StartDate", d, t.getStartDate());
        assertEquals("Expected organizer: organizer", u, t.getOrganiser());
        assertEquals("Expected startlocation: startlocation", "startlocation", t.getStartLocation());
        assertEquals("Expected description:", "beschrijving", t.getTripDescription());
        assertEquals("Expected bgcolor:", "blue", t.getBgcolor());
        assertEquals("Expected deelnames:", deelnameList, t.getDeelnames());
        assertEquals("Expected fontcolorcontent:", "red", t.getFontcolorContent());
        assertEquals("Expected fontcolortitle:", "green", t.getFontcolorTitle());
        assertEquals("Expected type:", "Tijdsgebonden", t.getTripType());
        assertEquals("Expected stopplaatsen:", stopPlaatsList, t.getStopPlaatsen());
        assertEquals("Expected tripcategorieen:", tripCategorieList, t.getTripCategorieen());
        assertEquals("Expected notification:", "notification", t.getNotification());
        assertEquals("Expected equipment:", equipment, t.getEquipment());
        assertEquals("Expected visible:", true, t.isVisible());
        assertEquals("Expected show map:", true, t.getShowMap());
        assertEquals("Expected show route:", true, t.getShowRoute());
        assertEquals("Expected travel type:", "Driving", t.getTravelType());
        assertEquals("Expected chats:", chats, t.getChats());
        assertEquals("Expected broadcast messages:", broadcastMessages, t.getBroadcastMessages());
    }



}
