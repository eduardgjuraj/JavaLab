package lab3ex1;

public class Parabola{
    public int a, b, c;
    Parabola (int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public void afisare() {
        System.out.print(" a:" + a + " b:" + b + " c:" + c);
        System.out.println();
    }

    public String toString(){
        String aString, bString, cString, fx;
        aString=Integer.toString(a);
        bString=Integer.toString(b);
        cString=Integer.toString(c);
        fx=aString+" x^2 + " + bString + " x + " + cString;
        return fx;
    }

    public String Coordonate(int a, int b, int c){  // -b/2*a & -b^2 + 4ac / 4a
        double x, y;
        x = (double) -b / 2*a;
        y = (double) (-b^2 + 4*a*c)/4*a;

        return  x + " , " + y;
    }

    public static String mijSegmentDr(int a1, int b1, int c1, int a2, int b2, int c2){
        double x1, y1, x2, y2, x, y;
        x1 = (double) -b1 / 2*a1;
        y1 = (double) (-b1^2 + 4*a1*c1)/4*a1;

        x2 = (double) -b2 / 2*a2;
        y2 = (double) (-b2^2 + 4*a2*c2)/4*a2;

        x= (x1+x2)/2;
        y= (y1+y2)/2;

        return  x + " , " + y;
    }

    public double lungDreapta(int a, int b, int c, double x2, double y2){
        double x1, y1;
        x1 = (double) -b / 2*a;
        y1 = (double) (-b^2 + 4*a*c)/4*a;

        double X, Y;
        X=x2-x1;
        Y=y2-y1;

        return Math.hypot(X,Y);
    }

    public double lungDreapta2Parabole(int a1, int b1, int c1, int a2, int b2, int c2){
        double x1, y1, x2, y2, x, y;
        x1 = (double) -b1 / 2*a1;
        y1 = (double) (-b1^2 + 4*a1*c1)/4*a1;

        x2 = (double) -b2 / 2*a2;
        y2 = (double) (-b2^2 + 4*a2*c2)/4*a2;

        double X, Y;
        X=x2-x1;
        Y=y2-y1;

        return Math.hypot(X,Y);
    }

}
