package Tema1;

import java.util.Random;
public class ex5 {
    public static boolean isFibonacci(int n)
    {
        int fib1=0;
        int fib2=1;
        do{
            int oldFib1=fib1;
            fib1 = fib2;
            fib2 = oldFib1+fib2;
        }while(fib2<n);

        if(fib2==n)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(21);
        if(isFibonacci(a))
            System.out.println("Numarul " + a + " aparatine sirului lui Fibonacci");
        else
            System.out.println("Numarul " + a + " nu aparatine sirului lui Fibonacci");
    }
}
