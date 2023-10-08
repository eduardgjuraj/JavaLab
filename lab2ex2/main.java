package lab2ex2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        String[] stringArray = new String[100];
        String nume_fis="C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab2ex2\\cantec_in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String linie = null;
        Vers[] v;

        v = new Vers[50];

        int k=0;
        while((linie=flux_in.readLine()) != null)
        {
            //stringArray[k] = linie;
            //k++;
            v[k] = new Vers(linie.toCharArray());
            k++;
        }

        PrintStream flux_out = new PrintStream("C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab2ex2\\cantec_out.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti gruparea de litere pe care doriti sa o contina versul la sfarsit: ");
        String a = scanner.next();
        System.out.println(a);
        for(int i = 0 ; i < k ; i++) {
            v[i].random();
            flux_out.println(v[i].afisare() + " " + v[i].vowels() + " " + v[i].versCuvinteLength() + " " + v[i].lastNLetters(a));
        }
    }
}
