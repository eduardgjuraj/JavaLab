package problema2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Vehicul {
    private String marca;
    private double pret;
    public Vehicul(){}

    public Vehicul(String marca, double pret) {
        this.marca = marca;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "marca='" + marca + '\'' +
                ", pret=" + pret +
                '}';
    }

    public String getMarca() {
        return marca;
    }
    @Value("Volvo")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPret() {
        return pret;
    }
    @Value("50000.00")
    public void setPret(double pret) {
        this.pret = pret;
    }
}
