package no.hvl.dat109.yatzoo;

public class Spill {
    private Spiller[] spillere;
    private Blokk blokk;
    private int runde;
    private Kopp kopp;

    public void spillRundeSpiller(Spiller spiller, int runde, Kopp kopp){
        for (int i = 0; i < 3 && !kopp.ferdig(); i++){
            blokk.finnSpill(spiller, runde, kopp);
        }
        spiller.giPoengTilSpiller(GiPoeng.giPoeng(runde, kopp), runde);
        kopp.resetKopp();
    }
}
