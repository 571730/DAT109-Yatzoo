package no.hvl.dat109.yatzoo;

/**
 * Lager spillet med noen spillere
 * Koppen og blokken lages også, dermed startes spillet
 */
public class Main {
    public static void main(String[] args) {
        Spiller mikkel = new Spiller("Mikkel");
        Spiller dust = new Spiller("Dust");
        Spiller[] spillere = new Spiller[2];
        spillere[0] = mikkel;
        spillere[1] = dust;
        Kopp kopp = new Kopp();
        Blokk blokk = new Blokk();
        Spill spill = new Spill(spillere, blokk, kopp);
        spill.spill();
    }
}
