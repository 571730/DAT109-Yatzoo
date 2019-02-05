package no.hvl.dat109.yatzoo;

/**
 * The type Spill.
 * Denne klassen har kontroll over alt
 */
public class Spill {
    private Spiller[] spillere;
    private Blokk blokk;
    private Kopp kopp;

    /**
     * Instantiates a new Spill.
     *
     * @param spillere the spillere
     * @param blokk    the blokk
     * @param kopp     the kopp
     */
    public Spill(Spiller[] spillere, Blokk blokk, Kopp kopp) {
        this.spillere = spillere;
        this.blokk = blokk;
        this.kopp = kopp;
    }

    /**
     * spiller en runde for en spiller
     * @param spiller spilleren som skal spille
     * @param runde hvilken runde vi er på
     * @param kopp koppen med terninger
     */
    public void spillRundeSpiller(Spiller spiller, int runde, Kopp kopp){
        for (int i = 0; i < 3 && !kopp.ferdig(); i++){
            blokk.finnSpill(spiller, runde, kopp);
        }
        int poeng = GiPoeng.giPoeng(runde, kopp);
        spiller.giPoengTilSpiller(poeng, runde);
        System.out.println("\n## " + spiller.toString() + " fikk " + poeng + " poeng denne runden!\n");
        kopp.resetKopp();
    }

    /**
     * Spiller seg gjennom hele spillet
     */
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

    /**
     * Finner ut hvem som vannt, og eventuelt om det ble uavgjort
     */
    public void finnVinner(){
        if (spillere.length < 2){
            System.out.println("Du var eneste spiller, dermed vant du, kult!");
            System.out.println("Du fikk " + spillere[0].hentPoeng() + " poeng!");
        } else{
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
    }

    /**
     * Brukes til å skrive ut navnet på runden vi spiller i konsollen
     * @param runde int som sier hvilken runde vi er på
     */
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
