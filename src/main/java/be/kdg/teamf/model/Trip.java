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

    @Column(name="TRIPNAME")
    private String tripName;

    @Column(name="STARTDATE")
    private Date startDate;

    @Column(name="ENDDATE")
    private Date endDate;

    @Column(name="ORGANISER")
    private String organiser;

    @Column(name="STARTLOCATION")
    private String startLocation;

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
}
