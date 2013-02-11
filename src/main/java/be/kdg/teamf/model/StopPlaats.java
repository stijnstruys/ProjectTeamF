package be.kdg.teamf.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="T_STOPPLAATS")
public class StopPlaats {
    @Id
    @Column(name="StopPlaatsID")
    @GeneratedValue
    private  int stopPlaatsID;
    @Column(name="Adres")
    private String adres;
    @Column(name="Vrijgegeven")
    private boolean vrijgegeven;


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

}
