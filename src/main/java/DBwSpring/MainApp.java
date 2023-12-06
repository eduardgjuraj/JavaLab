package DBwSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Year;
import java.util.List;
import java.util.Scanner;



public class MainApp {
    public static boolean isNewerThan5Years(int an){
        int currentYear = Year.now().getValue();
        return an > currentYear - 5;
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansDB.xml");
        OperatiiBD operatiiBD = (OperatiiBD) context.getBean("operatiiJDBC");
        Scanner scanner = new Scanner(System.in);

        List<Masina> listaMasini = operatiiBD.getListaMasina();

        do {
            System.out.println("1. Adăugarea unei mașini în BD\n" +
                    "2. Ștergerea unei mașini\n" +
                    "3. Căutarea unei mașini\n" +
                    "4. Afișarea tuturor mașinilor\n" +
                    "5. Afișarea numărului de mașini din BD care au o anumită marcă, introdusă de la " +
                    "tastatură.\n" +
                    "6. Afișarea a numărului de mașini din BD care au sub 100 000 km.\n" +
                    "7. Afișarea tuturor caracteristicilor pentru mașinile mai noi de 5 ani.\n" +
                    "8. Iesire");
            int opt;
            System.out.println("\nIntroduceti optiunea dorita: ");
            opt=scanner.nextInt();
            scanner.nextLine();
            switch(opt){
                case 1:
                    System.out.println(" - - - Adaugare in baze de date - - -");
                    operatiiBD.insert(scanner);
                    break;
                case 2:
                    System.out.println("Introduceti numarul de inmatriculare al masinii pe care doriti sa o stergeti: ");
                    int nrInmatriculareStergere = scanner.nextInt();
                    operatiiBD.delete(nrInmatriculareStergere);
                    break;
                case 3:
                    System.out.println("Introduceti numarul de inmatriculare al masinii pe care doriti sa o cautati: ");
                    int nrInmatriculareCautare = scanner.nextInt();
                    Masina m = operatiiBD.getMasina(nrInmatriculareCautare);
                    System.out.println(m);
                    break;
                case 4:
                    listaMasini = operatiiBD.getListaMasina();
                    for (Masina masina : listaMasini)
                        System.out.println(masina);
                    break;
                case 5:
                    System.out.println("Introduceti marca masinilor pe care doriti sa le afisati: ");
                    String marca = scanner.nextLine();
                    int counterMarca = 0;
                    for(Masina masina : listaMasini)
                        if(masina.getMarca().equals(marca))
                            counterMarca++;
                    System.out.println(counterMarca+ " masini cu marca introdusa!");
                    break;
                case 6:
                    int counterKm=0;
                    for (Masina masina : listaMasini)
                        if(masina.getNumarKm() < 100000)
                            counterKm++;
                    System.out.println(counterKm + " masini cu mai putin de 100.000 de km!");
                    break;
                case 7:
                    for(Masina masina : listaMasini)
                        if(isNewerThan5Years(masina.getAnulFabricatiei()))
                            System.out.println(masina.toString());
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }while(true);

    }
}
