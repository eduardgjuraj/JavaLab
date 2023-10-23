package lab4ex1;

public class Imprimanta extends Echipament{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private mod_tiparire mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, situatie situatie, String tip, int ppm, String rezolutie,
                      int p_car, mod_tiparire mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, situatie, tip);
        this.ppm=ppm;
        this.rezolutie=rezolutie;
        this.p_car=p_car;
        this.mod_tiparire=mod_tiparire;
    }

    @Override
    public String toString(){
        return super.toString()+ "Numar pagini pe minut: " + ppm + " Rezolutie: " + rezolutie + " Pagini/cartus " + p_car + " Mod tiparire " + mod_tiparire;
    }

    public void setMod_tiparire(lab4ex1.mod_tiparire mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }
}
