package Tema1;

import java.io.*;

import static java.lang.Math.pow;

public class ex2 {
    public static void main(String[] args) throws IOException {
        String linie;
        int sum=0, k=0, max = -1, min=100, num;
        float ma = 0;
        String nume_fis="Z:\\JavaLab\\JavaLab\\lab1\\Tema1\\in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        while((linie =flux_in.readLine())!=null) {
            num = Integer.parseInt(linie);
            sum =  sum + num;
            k++;
            if(num>max)
                max=num;
            if(num<min)
                min=num;
        }
        ma= (float) sum / k;

        nume_fis = "Z:\\JavaLab\\JavaLab\\lab1\\Tema1\\out.txt";

        PrintStream flux_out = new PrintStream (nume_fis);

        System.out.println("Numar max: " + max + "\n Numar min: " + min +
                "\n Suma: " + sum + "\n Media aritmetica: "+ ma);

        flux_out.print("Numar max: " + max + "\n Numar min: " + min +
                "\n Suma: " + sum + "\n Media aritmetica: "+ ma);
    }
}
