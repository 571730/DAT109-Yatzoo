package no.hvl.dat109.yatzoo;

public class Blokk {

    public int rundeBlokk(Spiller spiller, Terning[] terninger, int runde){

    }

    private int likeTerninger(Terning[] terninger, int runde){
        Symboler.EnumSymboler symbol = Symboler.tallTilSymbol(runde);
        int terningerSomSkalKastes = 6;

        for (int i = 0; i < terningerSomSkalKastes; i++){
            terninger[i].trill();
            Symboler.EnumSymboler symbolFraTerning = terninger[i].getSymbol();
            if (symbol == symbolFraTerning){
                te
            }
        }
    }
}
