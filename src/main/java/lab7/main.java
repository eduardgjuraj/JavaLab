package lab7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.sound.midi.Instrument;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {

    public static Set<InstrumentMuzical> citire(File inFile) throws IOException {
        Set<InstrumentMuzical> set = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        set = mapper.readValue(inFile, new TypeReference<Set<InstrumentMuzical>>() {});
        return set;
    }

    public static void scriere(File inFile, Set<InstrumentMuzical> set) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(inFile, set);

    }
    public static void main(String[] args) throws IOException {
        Set<InstrumentMuzical> instrumente = new HashSet<>();
        Set<InstrumentMuzical> instrumente2 = new HashSet<>();

        //1) Creează o colecție de tip Set<InstrumentMuzical> în care utilizând polimorfismul se
        //introduc 3 chitări şi 3 seturi de tobe.

        instrumente.add(new Chitara("chitaraProd1", 1200.0, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("chitaraProd2", 7500.0, TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("chitaraProd3", 1400.0, TipChitara.CLASICA, 6));

        instrumente.add(new SetTobe("tobeProd1", 6000.0, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("tobeProd2", 1800.0, TipTobe.ACUSTICE, 4, 2));
        instrumente.add(new SetTobe("tobeProd3", 5500.0, TipTobe.ELECTRONICE, 6, 4));

        instrumente.add(new Chitara("chitaraProd4", 1200.0, TipChitara.ELECTRICA, 6));
        instrumente.add(new SetTobe("tobeProd4", 8000.0, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new Chitara("chitaraProd5", 7500.0, TipChitara.ACUSTICA, 6));
        instrumente.add(new SetTobe("tobeProd5", 4800.0, TipTobe.ACUSTICE, 4, 2));
        instrumente.add(new Chitara("chitaraProd6", 6000.0, TipChitara.ELECTRICA, 7));
        instrumente.add(new SetTobe("tobeProd6", 4500.0, TipTobe.ACUSTICE, 5, 3));

        File file = new File("Z:\\JavaLab\\lab7\\src\\main\\resources\\instrumente.json");

        //2) Salvează colecția Set<InstrumentMuzical> în fișierul instrumente.json. Pentru ca în
        //fișierul json să fie salvat şi tipul obiectelor (care este necesar la citirea datelor din json
        //şi crearea obiectelor corespunzătoare) se configurează în funcția de scriere obiectul de
        //tip ObjectMapper în felul următor:

        scriere(file, instrumente);

        //3) Încarcă datele din fişierul instrumente.json în program, într-o colecție de tip
        //Set<InstrumentMuzical>, care va fi utilizată pentru rezolvarea cerințelor următoare.
        //Pentru ca operația de încărcare a datelor din json în program să reușească în contextual
        //în care se utilizează tipuri polimorfe, este necesar să se completeze deasupra clasei
        //abstracte adnotația de mai jos, care va ajuta la realizarea legăturii dintre tipurile
        //abstracte si implementările concrete.

        instrumente2 = citire(file);

        //4) Să se afișeze implementarea utilizată pentru interfața Set de către ObjectMapper în
        //urma citirii


        instrumente2
                .stream()
                .forEach(System.out::println);

        //5)Să se verifice dacă colecția Set permite sau nu duplicate, prin încercarea de a adăuga
        //un instrument care are aceleași caracteristici cu unul deja introdus. În urma verificării
        //se va afişa un mesaj corespunzător. Să se scrie codul care face ca duplicatele să nu fie
        //permise în colecţia Set


        System.out.println("\n\n");

        Set<InstrumentMuzical> instrumente3 = new HashSet<>();

        InstrumentMuzical chitara1 = new Chitara("testDuplicate1", 1000.0, TipChitara.ELECTRICA, 6);

        if(instrumente3.add(chitara1)){
            System.out.println("Chitara adaugata!");
        }
        else {
            System.out.println("Chitara exista in set");
        }

        InstrumentMuzical chitara2 = new Chitara("testDuplicate1", 1000.0, TipChitara.ELECTRICA, 6);

        if(instrumente3.add(chitara1)){
            System.out.println("Chitara adaugata!");
        }
        else {
            System.out.println("Chitara exista in set");
        }

        instrumente3
                .stream()
                .forEach(System.out::println);

        System.out.println("\n\n");
        // 6) Să se șteargă instrumentele din Set al căror preț este mai mare de 3000 de RON. Se va
        //utiliza metoda removeIf()
        System.out.println("Stergere instrumente cu pret mai mic decat 3000 de RON . . .");
        instrumente.removeIf(instrument -> instrument.getPret() < 3000);

        instrumente
                .stream()
                .forEach(System.out::println);

        System.out.println("\n\n");
        // 7) Să se afișeze toate datele chitărilor, utilizând Stream API şi operatorul instanceof
        System.out.println("Afisarea doar a chitarilor");
        instrumente
                .stream()
                .filter(instrument -> instrument instanceof Chitara)
                .forEach(System.out::println);

        System.out.println("\n\n");
        // 8) Să se afișeze toate datele tobelor, utilizând Stream API şi metoda getClass()
        System.out.println("Afisarea doar a tobelor");
        instrumente
                .stream()
                .filter(instrument -> instrument.getClass() == SetTobe.class)
                .forEach(System.out::println);
        System.out.println("\n\n");
        // 9) Să se afișeze datele chitării care are cele mai multe corzi, utilizând Stream API,
        //expresii Lambda, referințe la metode şi clasa Optional.
        Optional<Chitara> coardaChitara = instrumente
                .stream()
                .filter(instrument -> instrument instanceof Chitara)
                .map(instrument -> (Chitara) instrument )
                .max(Comparator.comparing(Chitara::getNr_corzi));
        System.out.println("Chitara cu cele mai multe corzi: ");
        System.out.println(coardaChitara.toString());
        System.out.println("\n\n");

        // 10) Să se afișeze datele tobelor acustice, ordonat după numărul de tobe din set utilizând
        // Stream API, referințe la metode, expresii Lambda, etc

        System.out.println("Datele tobelor ordonate dupa numarul de tobe din set: ");
        instrumente
                .stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .map(instrument -> (SetTobe)instrument)
                .sorted(Comparator.comparing(SetTobe::getNr_tobe))
                .forEach(System.out::println);
    }
}
