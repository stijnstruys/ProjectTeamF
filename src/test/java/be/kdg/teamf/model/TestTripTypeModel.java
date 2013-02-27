package be.kdg.teamf.model;

import be.kdg.teamf.dao.TripTypeDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 18/02/13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestTripTypeModel {

    @Autowired
    protected TripTypeDAO tripTypeDAO;

    @Test
    public void testAddTripType() throws Exception {
        TripType tt = new TripType();

        tt.setTripTypeName("publiek");
        tt.setTripTypeId(1);
        tt.setTripTypeDescription("test");
        tt.setTrips(new ArrayList<Trip>());
        assertEquals("Expected name: ", "publiek", tt.getTripTypeName());
        assertEquals("Expected id: ", 1, tt.getTripTypeId());
        assertEquals("Expected description: ", "test", tt.getTripTypeDescription());
        assertEquals("Expected size: ", 0, tt.getTrips().size());
    }

}
