package be.kdg.teamf.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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
}
