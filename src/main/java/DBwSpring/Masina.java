package DBwSpring;

class Masina {
    private int numarInmatriculare;
    private String marca;
    private int anulFabricatiei;
    private String culoarea;
    private int numarKm;

    public Masina(){}
    public Masina(int numarInmatriculare, String marca, int anulFabricatiei, String culoarea, int numarKm) {
        this.numarInmatriculare = numarInmatriculare;
        this.marca = marca;
        this.anulFabricatiei = anulFabricatiei;
        this.culoarea = culoarea;
        this.numarKm = numarKm;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "numarInmatriculare='" + numarInmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anulFabricatiei=" + anulFabricatiei +
                ", culoarea='" + culoarea + '\'' +
                ", numarKm=" + numarKm +
                '}';
    }

    public int getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(int numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public void setAnulFabricatiei(int anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public void setCuloarea(String culoarea) {
        this.culoarea = culoarea;
    }

    public int getNumarKm() {
        return numarKm;
    }

    public void setNumarKm(int numarKm) {
        this.numarKm = numarKm;
    }
}
