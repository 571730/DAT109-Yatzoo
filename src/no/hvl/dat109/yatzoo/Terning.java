package no.hvl.dat109.yatzoo;

import java.util.Random;

public class Terning {
    private Random rdn;
    private Symboler.EnumSymboler symbol;

    public Terning() {
        this.rdn = new Random();
    }

    public void trill(){
        int terningVerdi = rdn.nextInt(6) + 1;
        if (terningVerdi == 1){
            this.symbol = Symboler.EnumSymboler.LØVE;
        } else if(terningVerdi == 2){
            this.symbol = Symboler.EnumSymboler.SLANGE;
        } else  if (terningVerdi == 3){
            this.symbol = Symboler.EnumSymboler.PANDA;
        } else if (terningVerdi == 4){
            this.symbol = Symboler.EnumSymboler.GRIS;
        } else if (terningVerdi == 5){
            this.symbol = Symboler.EnumSymboler.ELEFANT;
        } else {
            this.symbol = Symboler.EnumSymboler.HVAL;
        }
    }

    public Symboler.EnumSymboler getSymbol() {
        return symbol;
    }

    public void setSymbol(Symboler.EnumSymboler symbol) {
        this.symbol = symbol;
    }
}
