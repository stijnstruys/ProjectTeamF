package be.kdg.teamf.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_BROADCASTMESSAGE")
public class BroadcastMessage {

    @Id
    @Column(name = "broadcastMessageID")
    @GeneratedValue
    private int broadcastMessageID;

    @Column(name = "msg")
    private String msg;

    @Column(name = "date")
    private Date date;

    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trip trip;

    public int getBroadcastMessageID() {
        return broadcastMessageID;
    }

    public void setBroadcastMessageID(int broadcastMessageID) {
        this.broadcastMessageID = broadcastMessageID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
