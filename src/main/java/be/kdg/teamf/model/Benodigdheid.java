package be.kdg.teamf.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 20/02/13
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_BENODIGDHEID")
public class Benodigdheid {


    @Id
    @Column(name = "BENODIGDHEIDID")
    @GeneratedValue
    private int benodigdheidID;

    @Column(name = "OMSCHRIJVING")
    private String omschrijving;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = ("trip"))
    private ArrayList<Deelname> deelnemers ;


    public Benodigdheid() {
    }


    public int getBenodigdheidID() {
        return benodigdheidID;
    }

    public void setBenodigdheidID(int benodigdheidID) {
        this.benodigdheidID = benodigdheidID;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public ArrayList<Deelname> getDeelnemers() {
        return deelnemers;
    }

    public void setDeelnemers(ArrayList<Deelname> deelnemers) {
        this.deelnemers = deelnemers;
    }
}
