package exemplul01;

public class Dreptunghi {
    private int lungime;
    private int latime;

    public void aria() {
        System.out.println("Aria dreptunghiului: " + (lungime * latime));
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public int getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }
}
