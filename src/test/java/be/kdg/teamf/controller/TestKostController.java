package be.kdg.teamf.controller;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 7-3-13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestKostController extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    DeelnameDAO deelnameDAO;
    @Autowired
    UserController userController;
    @Autowired
    KostController kostController;

    private final MockMultipartFile mockMultipartFile = new MockMultipartFile("test", new byte[0]);

    @Test
    public void testManageKosts() {
        Trip t = new Trip();
         maakDeelname(t);
        ModelAndView mav = kostController.manageKosts(new MockHttpServletRequest(),null);

        assertEquals("correct","Kost/kostManagement",mav.getViewName());
    }

    @Test
    public void testAdminKostTrip() {
        Trip t = new Trip();
        maakDeelname(t);

        ModelAndView maw = kostController.adminKostTrip(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId()) ;
        assertEquals("correct","Kost/adminKostTrip",maw.getViewName());
    }

    @Test
    public void testAddKost() {
        Trip t = new Trip();
        Deelname d = maakDeelname(t);

        Kost k = new Kost();

        String s = kostController.addKost(k,t.getTripId(),new MockHttpServletRequest());

        assertEquals("correct","redirect:/kost/kostenPerTrip" + t.getTripId()  + ".html",s);
    }

    @Test
    public void testUpdateKost() {
        Kost k = new Kost();

        Trip t = new Trip();
        Deelname d = maakDeelname(t);
        k.setDeelname(d);
        kostController.addKost(k,t.getTripId(),new MockHttpServletRequest());

        String s = kostController.updateKost(k,null);

        assertEquals("correct","redirect:/kost/kostenPerTrip" + t.getTripId() + ".html",s);
    }

    @Test
    public void testDeleteKost() {
        Kost k = new Kost();

        Trip t = new Trip();
        Deelname d = maakDeelname(t);
        k.setDeelname(d);
        kostController.addKost(k,t.getTripId(),new MockHttpServletRequest());

        String s = kostController.deleteKost(k.getKostId());

        assertEquals("correct","redirect:/kost/kostenPerTrip" + k.getDeelname().getTrip().getTripId() + ".html",s);
    }

    @Test
    public void testKostenPerTrip() {
        Kost k = new Kost();

        Trip t = new Trip();
        Deelname d = maakDeelname(t);
        k.setDeelname(d);
        kostController.addKost(k,t.getTripId(),new MockHttpServletRequest());

        ModelAndView maw = kostController.kostenPerTrip(t.getTripId(),new MockMultipartHttpServletRequest());

        assertEquals("correct","Kost/kostenPerTrip",maw.getViewName());
    }

    @Test
    public void testUpdateKostPage() throws Exception {
        Kost k = new Kost();


        Trip t = new Trip();
        Deelname d = maakDeelname(t);
        k.setDeelname(d);
        kostController.addKost(k,t.getTripId(),new MockHttpServletRequest());

        ModelAndView maw = kostController.updateKostPage(new MockHttpServletRequest(), new MockHttpServletResponse(),k.getKostId());

        assertEquals("correct","Kost/updateKost",maw.getViewName());
    }

    public User getUser() {
        User u = new User();
        u.setUsername("testunit");
        u.setPassword("test");
        return u;
    }

    public void authenticateUser(User u) {
        ArrayList<GrantedAuthority> g = new ArrayList<>();
        g.add(new SimpleGrantedAuthority("ROLE_USER"));


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u, u.getPassword(), g);

        Authentication auth = token;

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    private Deelname maakDeelname(Trip t){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        authenticateUser(u);
        Deelname d = new Deelname();
        tripDAO.addTrip(t);
        d.setTrip(t);
        d.setUser(u);
        deelnameDAO.addDeelname(d);
        return d;
    }
}
