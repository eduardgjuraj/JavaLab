package lab4ex1;

public class Copiator extends Echipament{
    private int p_ton;
    private format_copiere format_copiere;


    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, lab4ex1.situatie situatie, String tip, int p_ton, format_copiere format_copiere) {
        super(denumire, nr_inv, pret, zona_mag, situatie, tip);
        this.p_ton=p_ton;
        this.format_copiere=format_copiere;
    }

    @Override
    public String toString(){
        return super.toString() + "Numar pagini/ton: " + p_ton + " Format copiere: " + format_copiere;
    }

    public void setFormat_copiere(lab4ex1.format_copiere format_copiere) {
        this.format_copiere = format_copiere;
    }
}
