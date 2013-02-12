package be.kdg.teamf.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/02/13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="T_TRIPTYPE")
public class TripType {

    @Id
    @Column(name="TRIPTYPEID")
    @GeneratedValue
    private int tripTypeId;

    @Column(name="TRIPTYPENAME")
    private String tripTypeName;

    public int getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(int tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    public String getTripTypeName() {
        return tripTypeName;
    }

    public void setTripTypeName(String tripTypeName) {
        this.tripTypeName = tripTypeName;
    }
}
