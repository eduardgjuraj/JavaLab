package interfacesLambdaStreamAPIetc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {

    public static void scriere(List<Angajat> lista){
        try{
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire(){
        try{
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper= new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {});
            return angajati;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        int optiune;
        Scanner scanner = new Scanner(System.in);
        List<Angajat> angajati = citire();
        while(true){
            System.out.println("1. Afisarea listei");
            System.out.println("2. Afisarea angajatilor cu salariul peste 2500 ron");
            System.out.println("3. Crearea unei liste cu angajatii din luna aprilie care au functie de conducere");
            System.out.println("4. Afisarea angajatilor care nu au functie de conducere");
            System.out.println("5. Extragerea din lista de angajati a unei liste de String-uri cu numele angajatilor scrie cu majuscule");
            System.out.println("6. Afisarea angajatilor cu salariu mai mic de 3000 ron");
            System.out.println("7. Afisarea datelor primului angajat al firmei");
            System.out.println("8. Afisarea de statistici referitoare la salariul angajatilor");
            System.out.println("9. Afisarea unor mesaje care indica daca printre angajati exista cel putin un Ion");
            System.out.println("10. Afisarea numarului de persoane care s-au angajat in vara anului precedent");
            System.out.println("Introduceti optiunea: ");
            optiune=scanner.nextInt();
            switch(optiune){
                case 1:
                    angajati
                            .stream()
                            .forEach(System.out::println);
                    break;
                case 2: // slide 98 & 113 din curs
                    // predicate1.test(s)?s;
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getSalariu() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:

                    LocalDate lastYearApril = LocalDate.parse("2022-04-30");
                    LocalDate lastYearMarch = LocalDate.parse("2022-04-01");

                    List<Angajat> angajatiAprilie = angajati
                            .stream()
                            .filter(angajat -> angajat.getData_angajarii().isBefore(lastYearApril))
                            .filter(angajat -> Objects.equals(angajat.getPost(), "sef") || Objects.equals(angajat.getPost(), "director"))
                            .collect(Collectors.toList());
                    angajatiAprilie.forEach(System.out::println);
                    break;
                case 4:

                    angajati
                            .stream()
                            .filter(angajat -> Objects.equals(angajat.getPost(), "sef") || Objects.equals(angajat.getPost(), "director"))
                            .sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed())
                            .forEach(System.out::println);


                    break;
                case 5:

                    List<String> angajatiMAJ = angajati
                            .stream()
                            .map( nume -> nume.getNume().toUpperCase())
                            .collect(Collectors.toList());
                    angajatiMAJ.forEach(System.out::println);

                    break;
                case 6:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getSalariu() < 3000)
                            .map(Angajat::getSalariu)
                            .forEach(System.out::println);
                    break;
                case 7:

                    Optional<LocalDate> dataMinima = angajati
                            .stream()
                            .min((a1,a2) -> a1.getData_angajarii().compareTo(a2.getData_angajarii()))
                            .map(Angajat::getData_angajarii);
                    if(dataMinima.isEmpty()){
                        System.out.println("Nu exista un angajat");
                    }
                    else
                        System.out.println(dataMinima);


                    break;
                case 8:
                    DoubleSummaryStatistics summaryStatistics = angajati
                            .stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariu));
                    System.out.println("Average: " + summaryStatistics.getAverage() + "\n" +
                            "Max: " + summaryStatistics.getMax() + "\n" +
                            "Min: " + summaryStatistics.getMin());
                    break;
                case 9:
                     Optional<Angajat> angajatulIon = angajati
                             .stream()
                             .filter(angajat -> angajat.getNume().equals("Ion"))
                             .findAny();
                    angajatulIon.ifPresentOrElse(
                            angajat -> System.out.println("Firma are cel putin un Ion angajat"),
                            () -> System.out.println("Firma nu are nici un Ion angajat"));

                    break;
                case 10:
                    int anCurent = LocalDate.now().getYear();
                    long nrAngajatiVaraTrecuta = angajati
                            .stream()
                            .filter(angajat -> angajat.getData_angajarii().getYear() == anCurent -1 && (angajat.getData_angajarii().getMonthValue() >= 6 && angajat.getData_angajarii().getMonthValue() <= 8 ))
                            .count();

                    System.out.println("Numarul de oameni angajati vara trecuta este: " + nrAngajatiVaraTrecuta);
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
