package no.hvl.dat109.yatzoo;

import java.util.Random;

/**
 * The type Terning.
 * Denne holder kontrol over hvilket symbol en terning har
 * og lar terningen trilles
 */
public class Terning {
    private Random rdn;
    private Symboler.EnumSymboler symbol;

    /**
     * Instantiates a new Terning.
     */
    public Terning() {
        this.rdn = new Random();
    }

    /**
     * Constructor used for the testing
     * @param symbol to be put on the die
     */
    public Terning(Symboler.EnumSymboler symbol){
        rdn = new Random();
        this.symbol = symbol;
    }

    /**
     * Trill.
     * setter klasseverdien symbol til å være like et tilfeldig valgt symbol
     */
    public void trill(){
        int terningVerdi = rdn.nextInt(6) + 1;
        if (terningVerdi == 1){
            this.symbol = Symboler.EnumSymboler.LOEVE;
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

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public Symboler.EnumSymboler getSymbol() {
        return symbol;
    }

    /**
     * Sets symbol.
     *
     * @param symbol the symbol
     */
    public void setSymbol(Symboler.EnumSymboler symbol) {
        this.symbol = symbol;
    }
}
