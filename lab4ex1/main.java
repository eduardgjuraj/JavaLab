package lab4ex1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        String nume_fis = "C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab4ex1\\electronice.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));

        List<Echipament> listaEchipament = new ArrayList<Echipament>();
        List<Echipament> lista2 = new ArrayList<Echipament>();
        String linie;
        while ((linie = flux_in.readLine()) != null) {
            String[] elemente = linie.split(";");
            String denumire = elemente[0].trim();
            int nr_inv = Integer.parseInt(elemente[1].trim());
            double pret = Double.parseDouble(elemente[2].trim());
            String zona_mag = elemente[3].trim();
            situatie situatie = lab4ex1.situatie.valueOf(elemente[4].trim());
            String tip =  elemente[5].trim();
            if(tip.equals("imprimanta"))
            {
                int ppm = Integer.parseInt(elemente[6].trim());
                String rezolutie = elemente[7].trim();
                int p_car = Integer.parseInt(elemente[8].trim());
                mod_tiparire mod_tiparire = lab4ex1.mod_tiparire.valueOf(elemente[9].trim());
                Echipament echipament = new Imprimanta(denumire, nr_inv, pret, zona_mag, situatie, tip, ppm, rezolutie, p_car, mod_tiparire);
                listaEchipament.add(echipament);
            }
            if(tip.equals("copiator"))
            {
                int p_ton = Integer.parseInt(elemente[6].trim());
                format_copiere format_copiere = lab4ex1.format_copiere.valueOf(elemente[7].trim());
                Echipament echipament = new Copiator(denumire, nr_inv, pret, zona_mag, situatie, tip, p_ton, format_copiere);
                listaEchipament.add(echipament);
            }
            if(tip.equals("sistem de calcul"))
            {
                String tip_mon = elemente[6].trim();
                double vit_proc = Double.parseDouble(elemente[7].trim());
                String c_hdd = elemente[8].trim();
                sistem_operare sistem_operare = lab4ex1.sistem_operare.valueOf(elemente[9].trim());
                Echipament echipament = new SistemDeCalcul(denumire, nr_inv, pret, zona_mag, situatie, tip, tip_mon, vit_proc, c_hdd, sistem_operare);
                listaEchipament.add(echipament);
            }

        }
        Scanner scanner = new Scanner(System.in);
        int optiune;


        while (true) {
            System.out.println("0. Iesire");
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii in care se afla un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9.Afisarea echipamentelor vandute");
            System.out.println("10.Serializare");
            System.out.println("11.Deserializare");
            System.out.println("Introduceti optiunea pe care o doriti: ");

            optiune= scanner.nextInt();

            switch(optiune){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for(Echipament e : listaEchipament){
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                    for(Echipament e : listaEchipament){
                        if(e.getTip().equals("imprimanta")){
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 3:
                    for(Echipament e : listaEchipament){
                        if(e.getTip().equals("copiator")){
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 4:
                    for(Echipament e : listaEchipament) {
                        if (e.getTip().equals("sistem de calcul")) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cum se numeste echipamentul pe care doriti sa-l schimbati?");
                    String nume_echipament = scanner.nextLine();
                    nume_echipament = scanner.nextLine();
                    System.out.println("In ce stare doriti sa schimbati echipamentul? ( 0 -> achizitionat , 1 -> expus, 2-> vandut");
                    int stare_echipament = scanner.nextInt();
                    situatie stare_echipament_ENUM = situatie.values()[stare_echipament];

                        for (Echipament e : listaEchipament) {
                            if (e.getDenumire().equals(nume_echipament)) {
                                e.setSituatie(stare_echipament_ENUM);
                            }
                        }

                    break;
                case 6:
                    System.out.println("Cum se numeste imprimanta pe care doriti sa o schimbati?");
                    String nume_imprimanta = scanner.nextLine();
                    nume_imprimanta = scanner.nextLine();
                    System.out.println("Modul de scriere pe care doriti sa-l setati pentru imprimanta? ( 0 -> color , 1 -> alb_negru )");

                    int stare_imprimanta = scanner.nextInt();
                    mod_tiparire stare_imprimanta_ENUM = mod_tiparire.values()[stare_imprimanta];

                    for (Echipament e : listaEchipament) {
                        if (e.getDenumire().equals(nume_imprimanta)) {
                            Imprimanta eCastImprimanta = (Imprimanta) e;
                            eCastImprimanta.setMod_tiparire(stare_imprimanta_ENUM);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Cum se numeste copiatorul pe care doriti sa il schimbati?");
                    String nume_copiator = scanner.nextLine();
                    nume_copiator = scanner.nextLine();
                    System.out.println("Ce format de copiator doriti pentru copiator? ( 0 -> A3 , 1 -> A4 )");

                    int format_copiator = scanner.nextInt();
                    format_copiere format_copiator_ENUM = format_copiere.values()[format_copiator];

                    for (Echipament e : listaEchipament) {
                        if (e.getDenumire().equals(nume_copiator)) {
                            Copiator eCastCopiator = (Copiator) e;
                            eCastCopiator.setFormat_copiere(format_copiator_ENUM);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Cum se numeste sistemul de calcul pe care doriti sa il schimbati?");
                    String sistem_calcul = scanner.nextLine();
                    sistem_calcul = scanner.nextLine();
                    System.out.println("Ce sistem de operare doriti sa instalati? ( 0 -> Windows , 1 -> Linux )");

                    int sistem_operare_VAR = scanner.nextInt();
                    sistem_operare sistem_operare_ENUM = sistem_operare.values()[sistem_operare_VAR];

                    for (Echipament e : listaEchipament) {
                        if (e.getDenumire().equals(sistem_calcul)) {
                            SistemDeCalcul eSistemDeCalcul = (SistemDeCalcul) e;
                            eSistemDeCalcul.setSistem_operare(sistem_operare_ENUM);
                        }
                    }
                    break;
                case 9:
                    for(Echipament e : listaEchipament) {
                        if(e.getSituatie()==2)
                        {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 10:
                    String nameFile="C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab4ex1\\echip.bin";
                    serialCommands.serializeToFile(listaEchipament, nameFile);
                    break;
                case 11:
                    String nameFile2="C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab4ex1\\echip.bin";
                    lista2=serialCommands.deserializeFromFile(nameFile2);
                    for(Echipament e : lista2)
                    {
                        System.out.println(e.toString());
                    }
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }

        }
    }
}
