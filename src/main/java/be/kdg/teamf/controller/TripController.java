package be.kdg.teamf.controller;

import be.kdg.teamf.model.*;
import be.kdg.teamf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TripController {

    @Qualifier("tripServiceImpl")
    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeelnameService deelnameService;

    @Autowired
    private ChatService chatService;


    @RequestMapping(value = "/trip/tripOverzicht.html", method = RequestMethod.GET)
    public ModelAndView tripOverzichtPage(HttpServletRequest request, HttpServletResponse response) {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripList", tripService.listPublicTrips());

        ModelAndView model = new ModelAndView("Trip/tripOverzicht");
        return model;
    }

    @RequestMapping(value = "/search/tripSearchResult.html", params = {"searchInput"}, method = RequestMethod.GET)
    public ModelAndView tripSearchResult(HttpServletRequest request, @RequestParam("searchInput") String searchInput)  {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripSearchList", tripService.searchTrips(searchInput));
        request.setAttribute("tripSearchCategories", tripService.searchTripsCategories(searchInput));
        ModelAndView model = new ModelAndView("Trip/tripSearchResult");
        return model;
    }

    @RequestMapping(value = "/trip/addTrip.html", method = RequestMethod.GET)
    public ModelAndView addTripPage(HttpServletRequest request, HttpServletResponse response) {
        Trip t = new Trip();
        request.setAttribute("trip", t);

        ModelAndView model = new ModelAndView("Trip/addTrip");
        return model;
    }

    @RequestMapping(value = "trip/add", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip") Trip trip, BindingResult result, HttpServletRequest request) {
        trip.setOrganiser( userService.getCurrentUser() );
        tripService.addTrip(trip);
        if(trip.getTripType().equals("Herhalend")) {
            String t = request.getParameter("repetition");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date maxDate = null;
            try {
                maxDate = dateFormat.parse( request.getParameter("dateUntill") );
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            switch (t) {
                case "1d":
                    addTrips(dateFormat, maxDate, trip, 1);
                    break;
                case "1w":
                    addTrips(dateFormat, maxDate, trip, 7);
                    break;
                case "2w":
                    addTrips(dateFormat, maxDate, trip, 14);
                    break;
                case "4m":
                    addTrips(dateFormat, maxDate, trip, 28);
                    break;
            }
        }
        return "redirect:/trip/tripOverzicht.html";
    }

    public void addTrips(SimpleDateFormat sdf, Date maxDate, Trip startTrip, int interval) {
        Trip anotherTrip = startTrip;

        Calendar cStart = Calendar.getInstance();
        Calendar cEnd = Calendar.getInstance();

        boolean keepGoing = true;

        cStart.setTime(startTrip.getStartDate());
        cEnd.setTime(startTrip.getEndDate());

        cStart.add(Calendar.DATE, interval);
        anotherTrip.setStartDate(cStart.getTime());
        cEnd.add(Calendar.DATE, interval);
        anotherTrip.setEndDate(cEnd.getTime());

        if(anotherTrip.getStartDate().compareTo(maxDate) >= 0) {
            keepGoing = false;
        }

        while(keepGoing) {
            tripService.addTrip(anotherTrip);

            cStart.add(Calendar.DATE, interval);
            anotherTrip.setStartDate(cStart.getTime());
            cEnd.add(Calendar.DATE, interval);
            anotherTrip.setEndDate(cEnd.getTime());

            if(anotherTrip.getStartDate().compareTo(maxDate) >= 0) {
                keepGoing = false;
            }
        }
    }

    @RequestMapping("/trip/{tripID}")
    public ModelAndView viewTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID)  {

        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);
        ArrayList<StopPlaats> stopplaatsen =  new ArrayList<>();
        for(StopPlaats s : t.getStopPlaatsen()){
            if (s.isVrijgegeven()){
                stopplaatsen.add(s);
            }
        }
        t.setStopPlaatsen(stopplaatsen);
        if (u != null && deelnameService.userIsRegistered(t, u)) {
            request.setAttribute("registered", true);
        } else {
            request.setAttribute("registered", false);
        }
        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("Trip/viewTrip");
        return model;
    }

    /* Chat */
    /* add chat to db */
    @RequestMapping(value="/chat/add", method = RequestMethod.POST)
     @ResponseBody
    public void addChat(@RequestParam("trip") int trip, @RequestParam("msg") String msg) {
        chatService.addChat(new Chat(tripService.findTrip(trip), userService.getCurrentUser(), msg));
    }

    @RequestMapping(value="/android/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    void addChatAndroid(@RequestParam("trip") String trip, @RequestParam("msg") String msg, @RequestParam("userid") String userID) {
         User u = userService.findUser(Integer.valueOf(userID));
        chatService.addChat( new Chat(tripService.findTrip(Integer.valueOf(trip)), u, msg ));
    }

    /* get chats */
   // static class ChatList extends ArrayList<Chat> {  }

    @RequestMapping(value="/chat/getChat", method = RequestMethod.GET)
    @ResponseBody
    public  List<Chat> getChats(@RequestParam("trip") int tripid, @RequestParam("lastId") int lastID) {
        List<Chat> cl = new ArrayList<Chat>();

        Trip t = tripService.findTrip(tripid);
        List<Chat> temp =  chatService.getChats(tripid, lastID) ;

        if(temp == null) {
            return null;
        } else {
            for(Chat c : temp) {
                c.setTrip(null);

                User u = new User();
                u.setUsername(c.getUser().getUsername());
                u.setUserID(c.getUser().getUserID());
                c.setUser(u);

                cl.add(c);
            }
            return cl;
        }
    }

    @RequestMapping("/trip/join/{tripID}")
    public String joinTrip(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID)  {
        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);

        Deelname d = new Deelname(t, u);

        if (!deelnameService.alreadyExists(d)) {
            t.getDeelnames().add(d);

            tripService.updateTrip(t);
        }

        return "redirect:/trip/" + tripID + ".html";
    }

    @RequestMapping("/trip/leave/{tripID}")
    public String leaveTrip(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) {

        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);

        Deelname d = deelnameService.findDeelname(t, u);
        deelnameService.deleteDeelname(d);

        return "redirect:/trip/" + tripID + ".html";
    }

    @RequestMapping(value = "user/updateTrip", method = RequestMethod.POST)
    public String updateTrip(@ModelAttribute("trip") Trip trip, BindingResult result) {
        Trip t = tripService.findTrip(trip.getTripId());

        trip.setShowMap(t.getShowMap());
        trip.setTravelType(t.getTravelType());
        trip.setShowRoute(t.getShowRoute());

        trip.setOrganiser(userService.getCurrentUser());
        tripService.updateTrip(trip);
        return "redirect:/user/admincp-"+trip.getTripId()+".html";
    }

    @RequestMapping("user/deleteTrip/{tripId}")
    public String deleteTrip(@PathVariable("tripId") Integer tripId) {

        Trip t = tripService.findTrip(tripId);
        if (tripService.checkOwnership(t, userService.getCurrentUser())) {
            tripService.deleteTrip(tripId);
        }
        return "redirect:/user/myTrips.html";
    }

    @RequestMapping(value = "/service/getOpenTrips", method = RequestMethod.GET)
    @ResponseBody
    public List<Trip> getOpenTrips(){
        List<Trip> trips = new ArrayList<Trip>(tripService.listTrips());
        List<Trip> openTrips = new ArrayList<Trip>();
        for(Trip t:trips){
            if(t.isVisible()){

                Trip temp=t;
                temp.setOrganiser(userService.findUser(temp.getOrganiser().getUserID()));
                openTrips.add(temp);
            }
        }
        return openTrips;
    }
    @RequestMapping(value = "/service/tripList", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Trip> getTripList(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) {
        return tripService.listTrips();
    }

    @RequestMapping(value = "/service/getTripsUser", method = RequestMethod.POST,headers = "Accept=application/json")
    public List<Trip> tripListByUser(@RequestParam(value = "userid") int userid) {
        return tripService.listUserParticipateTrips(userid);
    }

}