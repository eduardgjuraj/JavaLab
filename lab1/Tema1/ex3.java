package Tema1;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n=");
        int n = scanner.nextInt();
        int k=0;
        for(int i=2;i<n;i++){
            if(n%i==0)
            {
                System.out.println(i + " este divizor a lui "+ n);
                k = 1;
            }
        }

        if (k==0)
            System.out.println(n + " este prim, nu are divizori.");

    }
}
