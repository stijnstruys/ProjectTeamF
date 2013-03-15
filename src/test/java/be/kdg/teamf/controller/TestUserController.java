package be.kdg.teamf.controller;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.apache.struts.mock.MockHttpServletResponse;
import org.apache.struts.mock.MockHttpSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 4/03/13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */

@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestUserController extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    DeelnameDAO deelnameDAO;

    @Autowired
    UserController userController;

    private final MockMultipartFile mockMultipartFile = new MockMultipartFile("test",new byte[0]);

    @Test
    public void testAddUser(){
        User u = getUser();
        String s;

        s = userController.addUser(u,mockMultipartFile, null);
        assertEquals("correcte login","redirect:/general/index.html",s);
    }

    @Test
    public void testDeleteUser(){
        User u = getUser();

        userController.addUser(u,mockMultipartFile, null);
        String s =  userController.deleteUser(u.getUserID());
        assertEquals("correct","redirect:/user/user.html",s);

    }

    @Test
    public void testUpdateUserPage(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        ModelAndView mav = userController.userPage(new MockHttpServletRequest(),null,u.getUserID());
        assertEquals("correct","User/updateUser",mav.getViewName());
    }

    @Test
    public void testGetImage(){
        User u = getUser();
        byte[] roemel = new byte[10];
        for(int i = 0; i<10;i++){
            roemel[i] = (byte) i;
        }
        MockMultipartFile brol = new MockMultipartFile("test",roemel);
        userController.addUser(u,brol, null);
        byte[] b = userController.getImage(u.getUserID());
        assertEquals("correct",new byte[10].length,b.length);
    }

    @Test
    public void testUserPage(){

        ModelAndView mav = userController.userPage(new MockHttpServletRequest(), null);
        assertEquals("correct","User/user",mav.getViewName());
    }

    @Test
    public void addSocial(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        MockHttpServletRequest mhsr =  new MockHttpServletRequest();
        mhsr.setParameter("userName","unittestuser");
        String s = userController.addSocialContact(mhsr, new MockHttpSession());
        assertEquals("correct","/general/index.html",s);

        mhsr.setParameter("userName","unittestandereuser");
        mhsr.setParameter("firstName", "test");
        mhsr.setParameter("id", "0");
        mhsr.setParameter("lastName", "test");
        mhsr.setParameter("email", "test@test.tes");
        mhsr.setParameter("birthday","10/10/10");

        s = userController.addSocialContact(mhsr, new MockHttpSession());
        assertEquals("correct","/general/index.html",s);
    }

    @Test
    public void updateUser(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        u.setUsername("iets anders");
        String s = userController.updateUserData(u,mockMultipartFile);
        assertEquals("correct","redirect:/user/profile.html",s);


    }

    @Test
    public void changePw(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);

        authenticateUser(u);

        ModelAndView mav = userController.changePw();
        assertEquals("correct","User/changepw",mav.getViewName());

        String s =  userController.changePw("test","nieuw","nieuw");
        assertEquals("correct","redirect:/user/profile.html",s);
        s =  userController.changePw("nieuw","nieuw1","nieuw");
        assertEquals("correct","redirect:/user/changepw.html",s);
        s =  userController.changePw("fout","nieuw1","nieuw1");
        assertEquals("correct","redirect:/user/changepw.html",s);
    }
    @Test
    public void testMails(){
        Trip t = new Trip();
        tripDAO.addTrip(t);
        String s = userController.mailForm("test","test","test","test",t.getTripId(),"test");
        assertEquals("correct", "true", s);

    }
    @Test
    public void viewProfile(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        ModelAndView mav = userController.viewProfile(new MockHttpServletRequest(),u.getUserID());
        assertEquals("correct","User/viewProfile",mav.getViewName());

    }

    @Test
    public void testProfile(){
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);

        authenticateUser(u);
        ModelAndView mav  = userController.profile(new MockHttpServletRequest());
        assertEquals("correct","User/profile",mav.getViewName());

    }

    @Test
    public void testTripOverzicht(){
        User u = getUser();

        userController.addUser(u,mockMultipartFile, null);

        authenticateUser(u);
        ModelAndView mav  = userController.tripOverzichtPage(new MockHttpServletRequest(),null);
        assertEquals("correct","User/myTrips",mav.getViewName());
    }





    @Test
    public void testAdminCP(){
        User u = getUser();
        User u2 = new User();
        userController.addUser(u,mockMultipartFile, null);
        userController.addUser(u2,mockMultipartFile, null);

        authenticateUser(u);

        Trip t = new Trip();
        t.setOrganiser(u2);
        tripDAO.addTrip(t);

        ModelAndView mav = userController.viewAdminTripPage(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId());
        assertEquals("correct","User/myTrips",mav.getViewName());
        t.setOrganiser(u);
        tripDAO.updateTrip(t);
        u.getTrips().add(t);
        userController.updateUserData(u,mockMultipartFile);
        mav = userController.viewAdminTripPage(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId());
        assertEquals("correct","User/adminTrip",mav.getViewName());
    }

    @Test
    public void testGetUserInJson() {
        User u = getUser();
        userController.addUser(u,mockMultipartFile, null);
        String s = userController.getUserInJson(u.getUsername());

        assertEquals("Correct","true",s);
    }
//
//    @Test
//    public void testServiceLogin() {
//        User u = getUser();
//        userController.addUser(u,mockMultipartFile);
//
//        User serviceLoginUser = userController.serviceLogin(u);
//
//        assertEquals("Correct",u.getUsername(),serviceLoginUser.getUsername());
//    }



    public User getUser(){
        User u = new User();
        u.setUsername("unittestuser");
        u.setPassword("test");
        u.setTrips(new ArrayList<Trip>());
        return u;
    }

    public void authenticateUser(User u){
        ArrayList<GrantedAuthority> g = new ArrayList<>();
        g.add(new SimpleGrantedAuthority("ROLE_USER"));


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u, u.getPassword(),g);

        Authentication auth = token;

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}