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

    public int hentPoeng(){
        return poeng.summerPoeng();
    }

    @Override
    public String toString(){
        return navn;
    }

    public void giPoengTilSpiller(int poeng, int runde){
        this.poeng.leggTilPoeng(runde, poeng);
    }

}
