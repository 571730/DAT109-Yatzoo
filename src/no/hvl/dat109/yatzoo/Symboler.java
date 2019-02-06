package no.hvl.dat109.yatzoo;

/**
 * Enum som holder styr på mulige symboler en kan få
 */
public class Symboler {
    public enum EnumSymboler{
        LOEVE,
        ELEFANT,
        HVAL,
        SLANGE,
        PANDA,
        GRIS
    }

    /**
     * Gjør om fra tall til en symbol
     * @param tall tilfeldig valgt tall 1-6
     * @return symbolet vi skal bruke
     */
    public static EnumSymboler tallTilSymbol(int tall){
        if (tall == 1){
            return EnumSymboler.LOEVE;
        } else if (tall == 2){
            return EnumSymboler.SLANGE;
        } else if (tall == 3) {
            return EnumSymboler.PANDA;
        } else if (tall == 4){
            return EnumSymboler.GRIS;
        } else  if (tall == 5){
            return EnumSymboler.ELEFANT;
        } else {
            return EnumSymboler.HVAL;
        }
    }
}
