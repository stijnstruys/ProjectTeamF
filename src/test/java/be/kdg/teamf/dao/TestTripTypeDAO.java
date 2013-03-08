package be.kdg.teamf.dao;

import be.kdg.teamf.model.TripType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 22/02/13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripTypeDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected TripTypeDAO tripTypeDAO;

    @Test
    public void addTripType() {
        TripType tt = new TripType();
        tt.setTripTypeName("Citytrip");
        tt.setTripTypeDescription("leukleukleuk");

        tripTypeDAO.addTripType(tt);
        assertEquals("Expected firstname: ", "Citytrip", tt.getTripTypeName());
        assertEquals("Expected firstname: ", "leukleukleuk", tt.getTripTypeDescription());

    }

    @Test
    public void testUpdateTripType() {
        TripType tt = new TripType();

        tt.setTripTypeName("Citytrip");
        tt.setTripTypeDescription("leukleukleuk");
        tripTypeDAO.addTripType(tt);
        tt.setTripTypeName("dropping");
        tt.setTripTypeDescription("saaisaaisaai");
        assertEquals("Expected firstname: ", "dropping", tripTypeDAO.findTripType(tt.getTripTypeId()).getTripTypeName());
        assertEquals("Expected firstname: ", "saaisaaisaai", tripTypeDAO.findTripType(tt.getTripTypeId()).getTripTypeDescription());

    }

    @Test
    public void deleteTripType() {
        TripType tt = new TripType();
        tt.setTripTypeName("Citytrip");
        tt.setTripTypeDescription("leukleukleuk");
        tripTypeDAO.addTripType(tt);
        tripTypeDAO.removeTripType(tt);
        assertTrue("TripType not found", !tripTypeDAO.listTripTypes().contains(tt));
    }

    @Test
    public void listTripTypes() {
        TripType tt1 = new TripType();
        tt1.setTripTypeName("Citytrip");
        tt1.setTripTypeDescription("leukleukleuk");
        TripType tt2 = new TripType();
        tt2.setTripTypeName("dropping");
        tt2.setTripTypeDescription("saaisaaisaai");
        tripTypeDAO.addTripType(tt1);
        tripTypeDAO.addTripType(tt2);

        assertEquals("Niet alle tripTypes worden opgehaald", 5, tripTypeDAO.listTripTypes().size());
    }

    @Test
    public void testFindDeelname() {
        TripType tt = new TripType();
        tt.setTripTypeName("publiek");
        tripTypeDAO.addTripType(tt);
        assertSame("you are not getting the expected triptype from the db","publiek",tripTypeDAO.findTripType(tt.getTripTypeId()).getTripTypeName());

    }
    @Test
    public void testNietGevonden() {

        assertNull(tripTypeDAO.findTripType(-1));
    }
}
