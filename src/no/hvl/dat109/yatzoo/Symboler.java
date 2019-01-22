package no.hvl.dat109.yatzoo;

public class Symboler {
    public enum EnumSymboler{
        LØVE,
        ELEFANT,
        HVAL,
        SLANGE,
        PANDA,
        GRIS;
    }

    public static EnumSymboler tallTilSymbol(int tall){
        if (tall == 1){
            return EnumSymboler.LØVE;
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
