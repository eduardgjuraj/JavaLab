package lab3ex2;

import lab3ex1.Parabola;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void afisareProduseExpirate(List<Produs> listaProduse) {
        LocalDate dataCurenta = LocalDate.now();
            for(Produs p : listaProduse){
                if(p.getExpirationDate().isBefore(dataCurenta))
                {
                    p.toString();
                }
            }
    }

    private static void vanzareProdus(List<Produs> listaProduse){
        double incasari = 0;
        System.out.println("Introduceti numele produsului pe care doriti sa-l vindeti:");
        Scanner scannerNumeProdusVandut = new Scanner(System.in);
        String numeProdus = scannerNumeProdusVandut.next();
        System.out.println("Introduceti cantitatea pe care doriti s-o vindeti:");
        Scanner scannerCantitateVanduta = new Scanner(System.in);
        int cantitateVanduta = scannerCantitateVanduta.nextInt();

        for(Produs p : listaProduse) {
            if(Objects.equals(p.getNumeProdus(), numeProdus))
            {
                if(p.getCantitate()>=cantitateVanduta){
                    incasari = p.getPret() * cantitateVanduta;
                    p.setIncasari(incasari);
                    p.setCantitate(p.getCantitate()-cantitateVanduta);
                    if(p.getCantitate()==0)
                    {
                        listaProduse.remove(p);
                    }
                    System.out.println("Cantitate vanduta!");
                    return;
                }
                else {
                    System.out.println("Cantitate insuficienta!");
                    return;
                }
            }
        }
    }

    private static void afisareProduseCuPretMinim(List<Produs> produse)
    {
        double pretMinim = produse.get(0).getPret();
        for (Produs p : produse){
            if(p.getPret() <= pretMinim)
            {
                pretMinim=p.getPret();
            }
        }

        for (Produs p : produse) {
            if(p.getPret() == pretMinim)
            {
                System.out.println(p.getNumeProdus());
            }
        }
    }

    private static void salvareProduseCantitateMica(List<Produs> listaProduse) throws IOException {
        System.out.println("Introduceti cantitatea minima: ");
        Scanner scannerCantitateMinima = new Scanner(System.in);
        int cantitateMinima = scannerCantitateMinima.nextInt();
        PrintStream flux_out = new PrintStream("C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab3ex2\\produse_cantitate_mica.txt");
        for(Produs p : listaProduse)
        {
            if(p.getCantitate()<cantitateMinima){
                flux_out.println(p.getNumeProdus());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String nume_fis = "C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab3ex2\\produse.csv";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));

        List<Produs> listaProduse = new ArrayList<Produs>();
        int a, b, c;
        String linie;
        while ((linie = flux_in.readLine()) != null) {
            String[] elemente = linie.split(",");
            String numeProdus = elemente[0].trim();
            double pret = Double.parseDouble(elemente[1].trim());
            int cantitate = Integer.parseInt(elemente[2].trim());
            LocalDate expirationDate = LocalDate.parse(elemente[3].trim());

            Produs produs = new Produs(numeProdus, pret, cantitate, expirationDate);
            listaProduse.add(produs);
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;

        while (true) {
            while (true) {
                System.out.println("Meniu:");
                System.out.println("1. Afișare toate produsele");
                System.out.println("2. Afișare produse expirate");
                System.out.println("3. Vânzare produs");
                System.out.println("4. Afișare produse cu preț minim");
                System.out.println("5. Salvare produse cu cantitate mică în fișier");
                System.out.println("6. Ieșire");

                optiune = scanner.nextInt();

                switch (optiune) {
                    case 1:
                        listaProduse.toString();
                        break;
                    case 2:
                        afisareProduseExpirate(listaProduse);
                        break;
                    case 3:
                        vanzareProdus(listaProduse);
                        break;
                    case 4:
                        afisareProduseCuPretMinim(listaProduse);
                        break;
                    case 5:
                        salvareProduseCantitateMica(listaProduse);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Optiune invalida! Introduceti o optiune valida.");
                }

            }
        }
    }
}
