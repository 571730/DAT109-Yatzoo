package no.hvl.dat109.yatzoo;

import java.util.Scanner;

/**
 * The type Blokk.
 * blokken blir brukt for å holde styr på hvilket spill som skal spilles gitt en runde
 */
public class Blokk {
    private Scanner sc;

    /**
     * Instantiates a new Blokk.
     */
    public Blokk(){
        sc = new Scanner(System.in);
    }

    /**
     * Finn spill.
     * finner ut hvilket spill vi skal spille gitt runde
     *
     * @param spiller the spiller
     * @param runde   the runde
     * @param kopp    the kopp
     */
    public void finnSpill(Spiller spiller, int runde, Kopp kopp){
        if (runde <= 6){
            likeTerninger(kopp, runde);
        } else {
            manuelleValg(kopp);
        }
    }

    /**
     * Om runden er 1-6 spiller vi like terninger
     * dette vil spille seg selv
     * @param kopp koppen
     * @param runde runden vi er på
     */
    private void likeTerninger(Kopp kopp, int runde){
        Symboler.EnumSymboler symbol = Symboler.tallTilSymbol(runde);
        kopp.trillAlleTerninger();
        kopp.sparTerning(symbol);
    }

    /**
     * De resterende spillene vil la brukeren selv velge hvilke terninger de skal spare
     * @param kopp koppen
     */
    private void manuelleValg(Kopp kopp){
        kopp.trillAlleTerninger();
        System.out.println("Skriv inn nummer på terningene som skal spares: (f.eks: 2 4 5)");
        System.out.println("Du kan fjerne sparte terninger ved å skrive en \"s\" før tallet (f.eks 2 s1 1)");
        String spares = sc.nextLine();
        kopp.sparManuel(spares);
    }
}
