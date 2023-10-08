package lab2ex4;

import java.util.Scanner;

public class main {

    public static int CheckCNP(String CNP)
    {
        int k=0;
        if(CNP.length()==13)
        {
            k=1;
        }
        else
            return 0;
        if(CNP.matches("[0-9]+"))
        {
            k=1;
        }
        else
            return 0;
        if(CNP.startsWith("1")||CNP.startsWith("2")||CNP.startsWith("5")||CNP.startsWith("6"))
        {
            k=1;
        }
        else
            return 0;

        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();

        Persoana[] p;
        p = new Persoana[n];

        String CNP;
        String nume;

        scanner.nextLine();

        for(int i=0;i<n;i++) {
            System.out.println("Introduceti numele");
            nume = scanner.nextLine();

            do{
                System.out.println("Introduceti CNP-ul corect: ");
                CNP = scanner.nextLine();
            }while(CheckCNP(CNP)==0);
            p[i] = new Persoana(nume, CNP);

        }

        for(int i=0 ; i < n ; i++)
        {
            p[i].afisare();
        }

    }
}
