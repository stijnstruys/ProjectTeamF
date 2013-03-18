package be.kdg.teamf.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_STOPPLAATS")
public class StopPlaats {

    @Id
    @Column(name = "StopPlaatsID")
    @GeneratedValue
    private int stopPlaatsID;
    @Column(name = "Adres", length = 255)
    private String adres;
    @Column(name = "Vrijgegeven")
    private boolean vrijgegeven = true;
    @Column(name = "Informatie", length = 255)
    private String informatie;
    @Column(name = "Type", length = 255)
    private String type;
    @Column(name = "Naam", length = 255)
    private String naam;
    @Column(name = "Vraag", length = 255)
    private String vraag;
    @Column(name = "CorrectAntwoord", length = 255)
    private String correctAntwoord;
    @Column(name = "CoorLat")
    private Double coorLat;
    @Column(name = "CoorLng")
    private Double coorLng;
    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    @Column(name = "Antwoorden")
    private Collection<String> antwoorden;

    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trip trip;

    public int getStopPlaatsID() {
        return stopPlaatsID;
    }

    public void setStopPlaatsID(int stopPlaatsID) {
        this.stopPlaatsID = stopPlaatsID;
    }

    public boolean isVrijgegeven() {
        return vrijgegeven;
    }

    public void setVrijgegeven(boolean vrijgegeven) {
        this.vrijgegeven = vrijgegeven;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {

        this.trip = trip;
    }

    public String getInformatie() {
        return informatie;
    }

    public void setInformatie(String informatie) {
        this.informatie = informatie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getCorrectAntwoord() {
        return correctAntwoord;
    }

    public void setCorrectAntwoord(String antwoord) {
        this.correctAntwoord = antwoord;
    }

    public Collection<String> getAntwoorden() {
        return antwoorden;
    }

    public void setAntwoorden(Collection<String> antwoorden) {
        this.antwoorden = antwoorden;
    }

    public Double getCoorLat() {
        return coorLat;
    }

    public void setCoorLat(Double coorLat) {
        this.coorLat = coorLat;
    }

    public Double getCoorLng() {
        return coorLng;
    }

    public void setCoorLng(Double coorLng) {
        this.coorLng = coorLng;
    }
}
