package be.kdg.teamf.service;

import be.kdg.teamf.model.TripType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 27/02/13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripTypeService  extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    TripTypeService tripTypeService;

    @Test
    public void addTripType(){
        TripType tt = new TripType();
        tt.setTripTypeName("test");
        tripTypeService.addTripType(tt);
        assertEquals("triptype not found",tt.getTripTypeName(),tripTypeService.findTripType(tt.getTripTypeId()).getTripTypeName());

    }

    @Test
    public void updateTripType(){
        TripType tt = new TripType();
        tt.setTripTypeName("test");
        tripTypeService.addTripType(tt);
        tt.setTripTypeName("iet anders");
        tripTypeService.updateTripType(tt);
        assertEquals("triptype not found",tt.getTripTypeName(),tripTypeService.findTripType(tt.getTripTypeId()).getTripTypeName());

    }

    @Test
    public void deleteTripType(){
        TripType tt = new TripType();
        tt.setTripTypeName("test");
        tripTypeService.addTripType(tt);
        tripTypeService.removeTripType(tt);
        assertFalse("triptype  found", tripTypeService.listTripTypes().contains(tt));

    }


    @Test
    public void findTripType(){
        TripType tt = new TripType();
        tt.setTripTypeId(1);
        tt.setTripTypeName("test");

        tripTypeService.addTripType(tt);

        assertEquals("triptype  found",tt ,tripTypeService.findTripType(tt.getTripTypeId()));

    }
}
