package lab4ex1;
import java.io.Serializable;

public class Echipament implements Serializable{
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private situatie situatie;
    private String tip;

    public Echipament(String denumire, int nr_inv, double pret,
                      String zonaMag, situatie situatie, String tip){
        this.denumire=denumire;
        this.nr_inv=nr_inv;
        this.pret=pret;
        this.zona_mag = zonaMag;
        this.situatie=situatie;
        this.tip=tip;
    }

    @Override
    public String toString(){
        return "Denumire: " + denumire + " Nr_inv: " + nr_inv + " Pret: " + pret + " Zona magazinului: " + zona_mag + " Situatie: " + situatie
                + " Tip: " + tip;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    public int getSituatie() {
        return situatie.ordinal();
    }

    public void setSituatie(situatie situatie) {
        this.situatie = situatie;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }



}


