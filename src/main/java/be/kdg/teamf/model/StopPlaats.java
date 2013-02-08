package be.kdg.teamf.model;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
public class StopPlaats {

    private String adres;
    private boolean vrijgegeven;


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
