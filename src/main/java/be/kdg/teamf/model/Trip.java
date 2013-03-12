package be.kdg.teamf.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

public class Trip {
    @Id
    @Column(name = "TripID")
    @GeneratedValue
    private int tripId;

    @Column(name = "TRIPNAME")
    private String tripName;

    @Column(name = "TRIPDESCRIPTION")
    private String tripDescription;

    @Column(name = "NOTIFICATION")
    private String notification;

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "STARTLOCATION")
    private String startLocation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    @Column(name = "Equipment")
    private Collection<String> equipment;

    @Column(name = "visible")
    private boolean visible = true;

    @Column(name = "FONTCOLORTITLE")
    private String fontcolorTitle = "#9CFF00";

    @Column(name = "FONTCOLORCONTENT")
    private String fontcolorContent = "#D4D4D4";

    @Column(name = "BGCOLOR")
    private String bgcolor = "#1C263C";

    @Column(name = "SHOWMAP")
    private boolean showMap = false;

    @Column(name = "SHOWROUTE")
    private boolean showRoute = true;

    @Column(name = "TRAVELTYPE")
    private String travelType;

    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User organiser;

    @Column(name = "TRIPTYPE")
    private String tripType;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = ("trip"))
    private Collection<StopPlaats> stopPlaatsen;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = ("trip"))
    private Collection<TripCategorie> tripCategorieen;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = ("trip"))
    private Collection<Deelname> deelnames;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = ("trip"))
    private Collection<Chat> chats;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = ("trip"))
    private Collection<BroadcastMessage> broadcastMessages;

    public Trip() {
    }

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

    public User getOrganiser() {
        return organiser;
    }

    public void setOrganiser(User organiser) {
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
        this.tripCategorieen = tripCategorieen;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Collection<Deelname> getDeelnames() {
        return deelnames;
    }

    public void setDeelnames(Collection<Deelname> deelnames) {
        this.deelnames = deelnames;
    }

    public String getFontcolorTitle() {
        return fontcolorTitle;
    }

    public String getFontcolorContent() {
        return fontcolorContent;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setFontcolorTitle(String fontcolorTitle) {
        this.fontcolorTitle = fontcolorTitle;
    }

    public void setFontcolorContent(String fontcolorContent) {
        this.fontcolorContent = fontcolorContent;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Collection<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(Collection<String> equipment) {
        this.equipment = equipment;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getShowMap() {
        return showMap;
    }

    public void setShowMap(boolean showMap) {
        this.showMap = showMap;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public boolean getShowRoute() {
        return showRoute;
    }

    public void setShowRoute(boolean showRoute) {
        this.showRoute = showRoute;
    }


    public Collection<Chat> getChats() {
        return chats;
    }

    public void setChats(Collection<Chat> chats) {
        this.chats = chats;
    }

    public Collection<BroadcastMessage> getBroadcastMessages() {
        return broadcastMessages;
    }

    public void setBroadcastMessages(Collection<BroadcastMessage> broadcastMessages) {
        this.broadcastMessages = broadcastMessages;
    }
}
