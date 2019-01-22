package no.hvl.dat109.yatzoo;

public class Poeng {
    private int[] poengListe;
    private Spiller eier;

    public Poeng(Spiller eier) {
        this.eier = eier;
        poengListe = new int[12];
    }

    public void leggTilPoeng(int runde, int poeng){
        poengListe[runde - 1] = poeng;
    }


}
