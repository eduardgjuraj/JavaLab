package Tema1;
import java.util.Random;
public class ex4 {
    public static int cmmdc(int a, int b)
    {
        if (b==0)
            return a;
        return cmmdc(b, a % b);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);
        System.out.println("CMMDC a lui " + a + " si " + b +" este " + cmmdc(a,b));

    }
}
