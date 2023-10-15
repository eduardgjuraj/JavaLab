package lab3ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {

        String nume_fis="C:\\Users\\Edy\\IdeaProjects\\JavaLab\\lab3ex1\\in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));

        List<Parabola> parabola = new ArrayList<Parabola>();
        int a,b,c;
        String linie;
        while((linie = flux_in.readLine())!=null ){
            a=Integer.parseInt(linie);
            b=Integer.parseInt(flux_in.readLine());
            c=Integer.parseInt(flux_in.readLine());
            parabola.add(new Parabola(a,b,c));
        }

        System.out.println("Lista contine parabolele:");
        for(Parabola p:parabola) {
            p.afisare();
            System.out.print(p.toString() + "                " + p.Coordonate(p.a, p.b, p.c));
            System.out.println();
        }
    }
}
