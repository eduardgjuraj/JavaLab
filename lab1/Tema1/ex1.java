package Tema1;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("introduceti latime: ");
        int latime = scanner.nextInt();
        System.out.println("introduceti lungime: ");
        int lungime = scanner.nextInt();
        System.out.println("Aria dreptunghiului este: "+ lungime*latime + "\n Perimetrul dreptunghiului" +
                " este: " + (2*lungime + 2*latime));
    }
}
