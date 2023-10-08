package lab2ex4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Persoana {
    private String Nume, CNP;

    Persoana(String Nume, String CNP) {
        this.Nume = Nume;
        this.CNP = CNP;
    }

    public int getVarsta()
    {
        int varsta=0;
        LocalDate currentDate = LocalDate.now();
        int year = Integer.parseInt(20+CNP.substring(1,3));
        int month= Integer.parseInt(CNP.substring(3,5));
        int day = Integer.parseInt(CNP.substring(5,7));

        LocalDate birthDate = LocalDate.of(year, month, day);

        varsta = (int) ChronoUnit.YEARS.between(birthDate, currentDate);

        return varsta;
    }

    public void afisare(){
        System.out.println("Nume: " + this.Nume + " CNP: " + this.CNP + " Varsta: " + getVarsta());
    }
}
