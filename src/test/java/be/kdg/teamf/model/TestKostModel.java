package be.kdg.teamf.model;

import be.kdg.teamf.dao.KostDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/03/13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestKostModel {

    @Autowired
    protected KostDAO kostDAO;

    @Test
    public void addKost() throws Exception {
        Deelname d = new Deelname();
        Kost k = new Kost();

        k.setKostId(1);
        k.setDeelname(d);
        k.setBeschrijving("lunch");
        k.setPrijs(5.0);

        assertEquals("Expected kostid:", 1, k.getKostId());
        assertEquals("Expected deelname:", d, k.getDeelname());
        assertEquals("Expected beschrijving:", "lunch", k.getBeschrijving());
        assertEquals("Expected prijs:", 5.0, k.getPrijs());

    }
}
