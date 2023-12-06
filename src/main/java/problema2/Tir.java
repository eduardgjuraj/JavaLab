package problema2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Tir extends Vehicul {
    private double incarcaturaMaxima;

    public double getIncarcaturaMaxima() {
        return incarcaturaMaxima;
    }


    @Value("5000")
    public void setIncarcaturaMaxima(double incarcaturaMaxima) {
        this.incarcaturaMaxima = incarcaturaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "Tir{" +
                "incarcaturaMaxima=" + incarcaturaMaxima +
                '}';
    }

    public Tir() {
    }

    public Tir(String marca, double pret, double incarcaturaMaxima) {
        super(marca, pret);
        this.incarcaturaMaxima = incarcaturaMaxima;
    }
    @PostConstruct
    public void init() {
        System.out.println("CREARE OBIECT ............");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DISTRUGERE OBIECT...................");
    }

}
