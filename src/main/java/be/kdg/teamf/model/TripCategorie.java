package be.kdg.teamf.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="T_TRIPCATEGORIE")
public class TripCategorie {
    @Id
    @Column(name="TRIPCATEGORIEID")
    @GeneratedValue
    private int tripCategorieId;

    @Column(name="TRIPCATEGORIENAME")
    private String tripCategorieName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

    public int getTripCategorieId() {
        return tripCategorieId;
    }

    public void setTripCategorieId(int tripCategorieId) {
        this.tripCategorieId = tripCategorieId;
    }

    public String getTripCategorieName() {
        return tripCategorieName;
    }

    public void setTripCategorieName(String tripCategorieName) {
        this.tripCategorieName = tripCategorieName;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
