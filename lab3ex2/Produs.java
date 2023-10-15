package lab3ex2;

import java.time.LocalDate;

public class Produs {
    private String numeProdus;
    private double pret;
    private int cantitate;
    private LocalDate expirationDate;
    private static double incasari;
    public Produs(String numeProdus, double pret, int cantitate, LocalDate expirationDate)
    {
        this.numeProdus = numeProdus;
        this.pret=pret;
        this.cantitate=cantitate;
        this. expirationDate = expirationDate;
    }

    public static void setIncasari(double incasari) {
        Produs.incasari = incasari;
    }

    @Override
    public String toString() {
        System.out.println("Nume produs: " + numeProdus + "\n" +
                "Pret: " + pret + "\n" +
                "Cantitate: " + cantitate + "\n" +
                "Data expirare: " + expirationDate + "\n");
        return null;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPret() {
        return pret;
    }

    public static double getIncasari() {
        return incasari;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
