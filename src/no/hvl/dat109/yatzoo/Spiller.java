package no.hvl.dat109.yatzoo;

/**
 * The type Spiller.
 */
public class Spiller {
    private String navn;
    private int posisjon;
    private Poeng poeng;

    /**
     * Instantiates a new Spiller.
     *
     * @param navn the navn
     */
    public Spiller(String navn) {
        this.navn = navn;
        posisjon = 1;
        poeng = new Poeng(this);
    }

    public void giPoengTilSpiller(int poeng, int runde){
        this.poeng.leggTilPoeng(runde, poeng);
    }

}
