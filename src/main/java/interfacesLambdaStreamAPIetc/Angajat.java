package interfacesLambdaStreamAPIetc;

import java.time.LocalDate;

public class Angajat {
    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salariu;

    public Angajat() {}
    public Angajat(String nume, String post, LocalDate data_angajarii, float salariu){
        super();
        this.nume=nume;
        this.post=post;
        this.data_angajarii=data_angajarii;
        this.salariu=salariu;
    }
    @Override
    public String toString(){
        return nume + ", " + post + ", " +
                data_angajarii + ", " + salariu;
    }
    public float getSalariu() {
        return salariu;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public String getNume() {
        return nume;
    }

    public String getPost() {
        return post;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }
}
