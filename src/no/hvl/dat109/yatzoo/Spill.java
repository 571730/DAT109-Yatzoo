package no.hvl.dat109.yatzoo;

public class Spill {
    private Spiller[] spillere;
    private Blokk blokk;
    private Kopp kopp;

    public Spill(Spiller[] spillere, Blokk blokk, Kopp kopp) {
        this.spillere = spillere;
        this.blokk = blokk;
        this.kopp = kopp;
    }

    public void spillRundeSpiller(Spiller spiller, int runde, Kopp kopp){
        for (int i = 0; i < 3 && !kopp.ferdig(); i++){
            blokk.finnSpill(spiller, runde, kopp);
        }
        int poeng = GiPoeng.giPoeng(runde, kopp);
        spiller.giPoengTilSpiller(poeng, runde);
        System.out.println("\n## " + spiller.toString() + " fikk " + poeng + " poeng denne runden!\n");
        kopp.resetKopp();
    }

    public void spill(){
        System.out.println("Spillet starter!");
        for (int i = 0; i < 12; i++){
            for (Spiller spiller : spillere){
                skrivUtRundeNavn(i + 1);
                System.out.println(spiller.toString() + " har for øyeblikket " + spiller.hentPoeng() + " poeng!\n");
                spillRundeSpiller(spiller, (i + 1), kopp);
            }
        }
        System.out.println("\nSpillet er over\n");
        finnVinner();
    }

    public void finnVinner(){
        Spiller vinner = spillere[0];
        Spiller andreVinner = spillere[1];
        for (Spiller spiller : spillere){
            if (spiller.hentPoeng() > vinner.hentPoeng()){
                andreVinner = vinner;
                vinner = spiller;
            }
        }
        if (vinner.hentPoeng() == andreVinner.hentPoeng()){
            System.out.println("Det ble uavgjort mellom " + vinner.toString() + " og " + andreVinner.toString());
        } else {
            System.out.println("Vinneren er " + vinner.toString() + " med " + vinner.hentPoeng() + " poeng!");
        }
        System.out.println("\nScoreboard:");
        for (Spiller spiller : spillere){
            System.out.println(spiller + " - " + spiller.hentPoeng() + " poeng");
        }
    }

    private void skrivUtRundeNavn(int runde){
        String rundeNavn = "Finn symboler";
        switch (runde){
            case 7:
                rundeNavn = Constants.TRELIKE;
                break;
            case 8:
                rundeNavn = Constants.FIRELIKE;
                break;
            case 9:
                rundeNavn = Constants.TOPAR;
                break;
            case 10:
                rundeNavn = Constants.HUS;
                break;
            case 11:
                rundeNavn = Constants.ALLEULIKE;
                break;
            case 12:
                rundeNavn = Constants.YATZOO;
                break;
        }
        System.out.println("- Vi spiller nå " + rundeNavn + "! -");
    }
}
