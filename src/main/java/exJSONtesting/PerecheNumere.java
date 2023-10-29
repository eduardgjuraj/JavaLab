package exJSONtesting;

import static java.util.Collections.swap;

/**
 * Clasa PerecheNumere reprezintă o pereche de două numere întregi.
 */

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere() {}

    /**
     * Constructorul clasei PerecheNumere.
     * @param a Primul număr din pereche.
     * @param b Al doilea număr din pereche.
     */
    public PerecheNumere(int a, int b)
    {
        super();
        this.a=a;
        this.b=b;
    }

    /**
     * Primeste ca valoare string valoarea parametrilor
     * @return
     */
    @Override
    public String toString(){
        return a + ", " + b;
    }

    /**
     * Primeste valoarea parametrului
     * @return
     */
    public int getA() {
        return a;
    }

    /**
     * Primeste valoarea parametrului
     * @return
     */
    public int getB() {
        return b;
    }

    /**
     * Seteaza valoarea parametrului
     * @param a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * Seteaza valoarea parametrului
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Interschimbă cele două numere din pereche
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        int aux;
        aux=a;
        a=b;
        b=aux;
    }

    /**
     * Verifică dacă cele două numere din pereche sunt consecutive în șirul lui Fibonacci.
     * @return true dacă cele două numere sunt consecutive în șirul Fibonacci, altfel false.
     */
    public boolean fibonacciConsecutiv(int a, int b){
        if(a<b)
            swap(a,b);
        while(a>1){
            a=a-b;
            swap(a,b);
        }
        if(a==1 && b==1)
            return true;
        else
            return false;
    }

    /**
     * Calculează și returnează cel mai mic multiplu comun al celor două numere.
     * @return Cel mai mic multiplu comun al celor două numere.
     */

    public int cmmmc(int a, int b){
        int r,p;
        r=a%b;
        p=a*b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return p/b;
    }

    /**
     * Verifică dacă cele două numere au suma cifrelor egală.
     * @return true dacă suma cifrelor celor două numere este egală, altfel false.
     */

    public boolean sumCifreEgale(int a, int b){
        int sum1=0, sum2=0;
        while(a!=0){
            sum1 += a%10;
            a /= 10;
        }

        while(b!=0){
            sum2 += b%10;
            b /= 10;
        }

        if(sum1==sum2)
            return true;
        else return false;
    }

    /**
     * Verifică dacă cele două numere au același număr de cifre pare.
     * @return true dacă cele două numere au același număr de cifre pare, altfel false.
     */

    public boolean evenCountNumber(int a, int b){
        int k1=0, k2=0;
        while(a!=0){
            if(a%2==0)
                k1++;
            a /= 10;
        }

        while(b!=0){
            if(b%2==0)
                k2++;
            b /= 10;
        }

        if(k1==k2)
            return true;
        else return false;

    }


}
