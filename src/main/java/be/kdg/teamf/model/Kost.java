package be.kdg.teamf.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_KOST")
public class Kost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kostId;

    @Column(name="prijs")
    private double prijs;

    @Column(name="beschrijving", length = 255)
    private String beschrijving;

    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Deelname deelname;

    public Kost() {
    }

    public int getKostId() {
        return kostId;
    }

    public void setKostId(int id) {
        this.kostId = id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Deelname getDeelname() {
        return deelname;
    }

    public void setDeelname(Deelname deelname) {
        this.deelname = deelname;
    }
}
