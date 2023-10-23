package lab4ex1;

public class SistemDeCalcul extends Echipament{
    private String tip_mon;
    private double vit_proc;
    private String c_hdd;

    private sistem_operare sistem_operare;


    public SistemDeCalcul(String denumire, int nr_inv, double pret, String zona_mag, lab4ex1.situatie situatie, String tip, String tip_mon, double vit_proc, String c_hdd, lab4ex1.sistem_operare sistem_operare) {
        super(denumire, nr_inv, pret, zona_mag, situatie, tip);
        this.tip_mon=tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd=c_hdd;
        this.sistem_operare = sistem_operare;
    }

    @Override
    public String toString(){
        return super.toString() + "Tip monitor: " + tip_mon + " Viteza procesor: " + vit_proc + " Capacitate HDD: " + c_hdd + "Sistem operare: " + sistem_operare;
    }

    public void setSistem_operare(lab4ex1.sistem_operare sistem_operare) {
        this.sistem_operare = sistem_operare;
    }
}
