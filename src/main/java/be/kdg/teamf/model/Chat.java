package be.kdg.teamf.model;

import be.kdg.teamf.model.component.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 7/03/13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_CHAT")
public class Chat {
    @Id
    @Column(name = "chatID")
    @GeneratedValue
    private int chatID;

    @Column(name = "msg", length = 255)
    private String msg;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trip trip;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Chat() {
    }

    public Chat(Trip trip, User user, String msg) {
        this.date = new Date();
        this.trip = trip;
        this.user = user;
        this.msg = msg;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
