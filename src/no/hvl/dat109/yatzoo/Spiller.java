package no.hvl.dat109.yatzoo;

/**
 * The type Spiller.
 */
public class Spiller {
    private String navn;
    private Poeng poeng;

    /**
     * Instantiates a new Spiller.
     *
     * @param navn the navn
     */
    public Spiller(String navn) {
        this.navn = navn;
        poeng = new Poeng(this);
    }

    /**
     * Henter ut spillerens totale poengsum
     *
     * @return int antall poeng totalt
     */
    public int hentPoeng(){
        return poeng.summerPoeng();
    }

    @Override
    public String toString(){
        return navn;
    }

    /**
     * Gi poeng til spiller.
     * Lar deg gi poeng til en spiller for en gitt runde
     *
     * @param poeng antall poeng som skal gis
     * @param runde runden poengene skal gjelde for
     */
    public void giPoengTilSpiller(int poeng, int runde){
        this.poeng.leggTilPoeng(runde, poeng);
    }

}
