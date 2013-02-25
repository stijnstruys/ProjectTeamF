package be.kdg.teamf.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_DEELNAME")
public class Deelname {
    @Id
    @Column(name = "DEELNAMEID")
    @GeneratedValue
    private int deelnameID;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trip trip;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    @Column(name="Equipment")
    private Collection<String> equipment;

    public Deelname() {
    }

    public Deelname(Trip t, User u) {
        trip = t;
        user = u;
    }

    public int getDeelnameID() {
        return deelnameID;
    }

    public void setDeelnameID(int deelnameID) {
        this.deelnameID = deelnameID;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(Collection<String> userEquipment) {
        this.equipment = userEquipment;
    }
}
