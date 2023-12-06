package problema2;

public class Autoturism extends Vehicul{
    private double volum;
    private double greutate;

    @Override
    public String toString() {
        return  super.toString() + "Autoturism{" +
                "volum=" + volum +
                ", greutate=" + greutate +
                '}';
    }

    public Autoturism (){}
    public Autoturism(String marca, double pret, double volum, double greutate) {
        super(marca, pret);
        this.volum = volum;
        this.greutate = greutate;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }
}
