package be.kdg.teamf.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 13/02/13
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_TRIPTYPE")
public class TripType {

    @Id
    @Column(name = "TRIPTYPEID")
    @GeneratedValue
    private int tripTypeId;

    @Column(name = "TRIPTYPENAME")
    private String tripTypeName;

    @Column(name = "TRIPTYPEDESCRIPTION")
    private String tripTypeDescription;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = ("tripType"))
    private Collection<Trip> trips;

    public int getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(int tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    public String getTripTypeName() {
        return tripTypeName;
    }

    public void setTripTypeName(String tripTypeName) {
        this.tripTypeName = tripTypeName;
    }

    public String getTripTypeDescription() {
        return tripTypeDescription;
    }

    public void setTripTypeDescription(String tripTypeDescription) {
        this.tripTypeDescription = tripTypeDescription;
    }

    public Collection<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Collection<Trip> trips) {
        this.trips = trips;
    }
}
