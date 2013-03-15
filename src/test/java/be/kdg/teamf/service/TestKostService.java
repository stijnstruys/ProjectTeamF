package be.kdg.teamf.service;

import be.kdg.teamf.model.Kost;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/03/13
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestKostService extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    KostService kostService;
    @Autowired
    UserService userService;
    @Autowired
    TripService tripService;
    @Autowired
    DeelnameService deelnameService;

    @Test
    public void addKost() {
        Kost k = new Kost();
        k.setKostId(1);
        kostService.addKost(k);
        assertEquals("kost not found", k.getKostId(), kostService.findKost(k.getKostId()).getKostId());
    }

    @Test
    public void updateKost() {
        Kost k = new Kost();
        k.setBeschrijving("lunch");
        k.setPrijs(5.0);
        kostService.addKost(k);
        k.setBeschrijving("ontbijt");
        kostService.updateKost(k);

        assertEquals("kost not found", k.getBeschrijving(), kostService.findKost(k.getKostId()).getBeschrijving());

    }

    @Test
    public void deleteKost() {
        Kost k = new Kost();
        kostService.addKost(k);
        kostService.deleteKost(k);

        assertEquals("kost deleted", null, kostService.findKost(k.getKostId()));
    }







    @Test
    public void testFindKost() {

        Kost k = new Kost();
        k.setKostId(1);

        kostService.addKost(k);
        assertEquals("kost not found", k, kostService.findKost(k.getKostId()));
    }

}
