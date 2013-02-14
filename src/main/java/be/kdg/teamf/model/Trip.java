package be.kdg.teamf.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_TRIP")
public class Trip {
    @Id
    @Column(name = "TripID")
    @GeneratedValue
    private int tripId;

    @Column(name = "TRIPTYPE")
    private String tripType;

    @Column(name = "TRIPNAME")
    private String tripName;

    @Column(name = "TRIPDESCRIPTION")
    private String tripDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "ORGANISER")
    private String organiser;

    @Column(name = "STARTLOCATION")
    private String startLocation;


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = ("trip"))
    private Collection<StopPlaats> stopPlaatsen;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = ("trip"))
    private Collection<TripCategorie> tripCategorieen;

    public Trip() {
    }

    @OneToMany
    private Collection<User> deelnemers;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
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

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public Collection<StopPlaats> getStopPlaatsen() {
        return stopPlaatsen;
    }

    public void setStopPlaatsen(Collection<StopPlaats> stopPlaatsen) {
        this.stopPlaatsen = stopPlaatsen;
    }

    public Collection<TripCategorie> getTripCategorieen() {
        return tripCategorieen;
    }

    public void setTripCategorieen(Collection<TripCategorie> tripCategorieen) {
        this.tripCategorieen =tripCategorieen;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Collection<User> getDeelnemers() {
        return deelnemers;
    }

    public void setDeelnemers(Collection<User> deelnemers) {
        this.deelnemers = deelnemers;
    }
}
