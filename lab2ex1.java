import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class lab2ex1 {
    public static void main(String[] args) throws IOException {
        String nume_fis = "C:\\Users\\Edy\\IdeaProjects\\JavaLab\\judete_in.txt";
        List<String> ArrayJudete = new ArrayList<>();
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String linie = flux_in.readLine();
        while(linie != null)
        {
            ArrayJudete.add(linie);
            linie=flux_in.readLine();
        }
        String[] array = ArrayJudete.toArray(new String[0]);
        Arrays.sort(array);

        System.out.println("Introduceti judetul pe care doriti sa-l cautati: ");
        Scanner scanner = new Scanner(System.in);
        String judetCautat = scanner.next();

        int poz= -1;
        poz = Arrays.binarySearch(array, judetCautat);

        if (poz==-1)
        {
            System.out.println("Judetul nu a fost gasit");
        }
        else
        {
            System.out.println("Judetul a fost gasit pe pozitia: " + poz);
        }

    }
}
