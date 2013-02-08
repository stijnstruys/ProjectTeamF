package be.kdg.teamf.model;

import java.util.Date;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="T_TRIP")
public class Trip {
    @Id
    @Column(name="TripID")
    @GeneratedValue
    private Integer tripId;

    @Column(name="TRIPNAAM")
    private String tripNaam;

    @Column(name="STARTDATUM")
    private Date startDatum;

    @Column(name="EINDDATUM")
    private Date eindDatum;

    @Column(name="ORGANISATOR")
    private String organisator;

    @Column(name="STARTLOCATIE")
    private String startLocatie;

    /*public Trip( String tripNaam, Date startDatum, Date eindDatum, String organisator, String startLocatie) {
        this.tripNaam=tripNaam;
        this.startDatum=startDatum;
        this.eindDatum=eindDatum;
        this.organisator=organisator;
        this.startLocatie=startLocatie;
    } */

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripNaam() {
        return tripNaam;
    }

    public void setTripNaam(String tripNaam) {
        this.tripNaam = tripNaam;
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
