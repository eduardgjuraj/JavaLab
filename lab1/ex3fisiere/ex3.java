package ex3fisiere;

import java.io.*;

public class ex3 {
    public static void main(String[] args) throws IOException {
        String nume_fis="Z:\\JavaLab\\JavaLab\\src\\ex3fisiere\\in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String linie = flux_in.readLine();
        System.out.println(linie);
    }
}
