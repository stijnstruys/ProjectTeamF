package be.kdg.teamf.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class Trip {
    private String trip;
    private Date startDatum;
    private Date eindDatum;
    private String organisator;
    private String startLocatie;

    public Trip(String trip, Date startDatum, Date eindDatum, String jeroen, String groenplaats) {
        //To change body of created methods use File | Settings | File Templates.

    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public String getStartLocatie() {
        return startLocatie;
    }

    public void setStartLocatie(String startLocatie) {
        this.startLocatie = startLocatie;
    }
}
