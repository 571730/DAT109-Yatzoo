package no.hvl.dat109.yatzoo;

import java.util.Scanner;

public class Blokk {
    private Scanner sc;

    public Blokk(){
        sc = new Scanner(System.in);
    }

    public void finnSpill(Spiller spiller, int runde, Kopp kopp){
        if (runde <= 6){
            likeTerninger(kopp, runde);
        } else {
            manuelleValg(kopp);
        }
    }

    private void likeTerninger(Kopp kopp, int runde){
        Symboler.EnumSymboler symbol = Symboler.tallTilSymbol(runde);
        kopp.trillAlleTerninger();
        kopp.sparTerning(symbol);
    }

    private void manuelleValg(Kopp kopp){
        kopp.trillAlleTerninger();
        System.out.println("Skriv inn nummer på terningene som skal spares: (f.eks: 2 4 5)");
        System.out.println("Du kan også bytte terninger med de sparte slik: 1-2 2-1");
        String spares = sc.nextLine();
        kopp.sparManuel(spares);
    }
}
