package lab2ex2;
import java.util.Random;
class Vers {
    private char[] vers;

    Vers(char[] vers)
    {
        this.vers = vers;
    }

    public String afisare()
    {
        String sir = new String (vers);
        return sir;
    }

    public int vowels(){
        int v=0;
        for(int i=0;i<vers.length;i++)
        {
            if(vers[i] == 'a' || vers[i] == 'e' || vers[i]=='i'
                    || vers[i] == 'o' || vers[i] == 'u' )
                v++;
        }

        return v;
    }

    public int versCuvinteLength() {
        int i=0,k=0;
        for(i=0;i<vers.length;i++)
        {
            if(vers[i]==' ')
            {
                k++;
            }
        }
        return k+1;
    }

    public char lastNLetters(String lastNLetters){
        int i=0;
        char k=' ';
        String sir = new String(vers);
        if(sir.endsWith(lastNLetters))
        {
                k = '*';
        }
        return k;
    }

    public void random()
    {
        Random rand = new Random();
        double a = rand.nextDouble(1);
        if(a<0.1)
        {
            for(int i=0;i<vers.length; i++)
            {
                vers[i]=Character.toUpperCase(vers[i]);
            }
        }


    }

}
