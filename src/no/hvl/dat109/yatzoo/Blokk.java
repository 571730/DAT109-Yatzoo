package no.hvl.dat109.yatzoo;

public class Blokk {

    public void finnSpill(Spiller spiller, int runde, Kopp kopp){
        if (runde <= 6){
            likeTerninger(kopp, runde);
        }
    }

    private void likeTerninger(Kopp kopp, int runde){
        Symboler.EnumSymboler symbol = Symboler.tallTilSymbol(runde);
        kopp.trillAlleTerninger();
        kopp.sparTerning(symbol);
    }
}
