package problema2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Motocicleta extends Vehicul implements InitializingBean, DisposableBean {
    private double vitezaMax;

    public Motocicleta(){}

    public Motocicleta(String marca, double pret, double vitezaMax) {
        super(marca, pret);
        this.vitezaMax = vitezaMax;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SE STERGE OBIECTUL.............");
    }
    @Override
    public String toString() {
        return super.toString()+ "Motocicleta{" +
                "vitezaMax=" + vitezaMax +
                '}';
    }

    public double getVitezaMax() {
        return vitezaMax;
    }

    public void setVitezaMax(double vitezaMax) {
        this.vitezaMax = vitezaMax;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SE CREEAZA OBIECTUL.................");
    }
}
