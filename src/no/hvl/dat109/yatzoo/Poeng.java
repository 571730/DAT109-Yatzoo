package no.hvl.dat109.yatzoo;

/**
 * Poengklassen brukes for å holde orden på en spiller sine poeng
 */
public class Poeng {
    private int[] poengListe;
    private Spiller eier;

    /**
     * Instantiates a new Poeng.
     *
     * @param eier the eier
     */
    public Poeng(Spiller eier) {
        this.eier = eier;
        poengListe = new int[12];
    }

    /**
     * Legg til poeng.
     * legger til poeng for en gitt runde
     *
     * @param runde runden poengene skal gjelde
     * @param poeng antall poeng som skal gis
     */
    public void leggTilPoeng(int runde, int poeng){
        poengListe[runde - 1] = poeng;
    }

    /**
     * Hent poeng string.
     * Henter en streng som viser totalt antall poeng
     *
     * @return the string
     */
    public String hentPoeng(){
        return eier.toString() + " har " + summerPoeng() + " poeng";
    }

    /**
     * Summer poeng int.
     *
     * @return the int
     */
    public int summerPoeng(){
        int sum = 0;
        for (int num : poengListe){
            sum += num;
        }
        return sum;
    }
}
