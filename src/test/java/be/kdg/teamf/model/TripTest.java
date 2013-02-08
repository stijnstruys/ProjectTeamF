package be.kdg.teamf.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class TripTest {

    @Test
    public void testCreateTrip() throws Exception {
        Date startDatum = new Date(7/10/2013);
        Date eindDatum = new Date(17/10/2013);

        /*Trip trip = new Trip("Trip1", startDatum, eindDatum, "Jeroen", "Groenplaats");
        assertEquals("Trip1", trip.getTrip());
        assertEquals(startDatum, trip.getStartDatum());
        assertEquals(eindDatum, trip.getEindDatum());
        assertEquals("Jeroen", trip.getOrganisator());
        assertEquals("Groenplaats", trip.getStartLocatie()); */
    }

    @Test
    public void testUpdateTrip(){

    }


}
