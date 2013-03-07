package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Kost;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/03/13
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestKostDAO {

    @Autowired
    protected KostDAO kostDAO;

    @Autowired
    protected DeelnameDAO deelnameDAO;

    @Test
    public void testAddKost() {
        Kost k = getKost();
        kostDAO.addKost(k);
        assertEquals("Expected prijs: ", 5.0, kostDAO.findKost(k.getKostId()).getPrijs());
        assertEquals("Expected Beschrijving", "lunch", kostDAO.findKost(k.getKostId()).getBeschrijving());
        assertEquals("Expected deelname", k.getDeelname(), kostDAO.findKost(k.getKostId()).getDeelname());

    }

    @Test
    public void testDeleteKost() {
        Kost k = getKost();
        kostDAO.addKost(k);
        kostDAO.deleteKost(k);

        assertTrue("Kost not found", !kostDAO.findKost(k.getKostId()).equals(k));
    }

    @Test
    public void testUpdateKost() {

        Kost k = getKost();
        kostDAO.addKost(k);
        k.setBeschrijving("ontbijt");
        kostDAO.updateKost(k);

        assertEquals("Expected beschrijving: ", "ontbijt", kostDAO.findKost(k.getKostId()).getBeschrijving());
    }

    private Kost getKost() {
        Kost k = new Kost();
        Deelname d = new Deelname();
        deelnameDAO.addDeelname(d);
        k.setDeelname(d);
        k.setBeschrijving("lunch");
        k.setPrijs(5.0);
        k.setKostId(1);

        return k;
    }

}
