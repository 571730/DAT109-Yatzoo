package no.hvl.dat109.tester;


import no.hvl.dat109.yatzoo.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tester for all logikk
 */
public class EnhetsTester {
    private Kopp kopp;
    private Blokk blokk;
    private Spiller spiller;


    /**
     * Setup.
     */
    @Before
    public final void setup(){
        kopp = new Kopp();
        blokk = new Blokk();
        spiller = new Spiller("Bob");
    }


    /**
     * Tester om en får riktig antall poeng for 1 lik, 2 like, 3 like osv.
     */
    @Test
    public void testPoengLike(){
        while (kopp.getSpareTerninger().size() != 5){
            kopp.trillAlleTerninger();
            kopp.sparTerning(Symboler.EnumSymboler.ELEFANT);
        }
        assertEquals(5, GiPoeng.giPoeng(5, kopp));
    }

    /**
     * Test tre like.
     */
    @Test
    public void testTreLike(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            spar.add(new Terning(Symboler.EnumSymboler.LØVE));
        }
        kopp.setSpareTerninger(spar);
        assertEquals(3, GiPoeng.giPoeng(7, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(7, kopp));
    }

    /**
     * Test fire like.
     */
    @Test
    public void testFireLike(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            spar.add(new Terning(Symboler.EnumSymboler.LØVE));
        }
        kopp.setSpareTerninger(spar);
        assertEquals(4, GiPoeng.giPoeng(8, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(8, kopp));
    }

    /**
     * Test to par.
     */
    @Test
    public void testToPar(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            Terning t =  (i % 2 == 0) ? new Terning(Symboler.EnumSymboler.LØVE) : new Terning(Symboler.EnumSymboler.HVAL);
            spar.add(t);
        }
        kopp.setSpareTerninger(spar);
        assertEquals(4, GiPoeng.giPoeng(9, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(9, kopp));
    }

    /**
     * Test hus.
     */
    @Test
    public void testHus(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Terning t =  (i % 2 == 0) ? new Terning(Symboler.EnumSymboler.LØVE) : new Terning(Symboler.EnumSymboler.HVAL);
            spar.add(t);
        }
        kopp.setSpareTerninger(spar);
        assertEquals(5, GiPoeng.giPoeng(10, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(10, kopp));
    }

    /**
     * Test ulike.
     */
    @Test
    public void testUlike(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (Symboler.EnumSymboler symbol : Symboler.EnumSymboler.values()){
            spar.add(new Terning(symbol));
        }
        spar.remove(5);
        kopp.setSpareTerninger(spar);
        assertEquals(5, GiPoeng.giPoeng(11, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(11, kopp));
    }

    /**
     * Test yatzoo.
     */
    @Test
    public void testYatzoo(){
        ArrayList<Terning> spar = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            spar.add(new Terning(Symboler.EnumSymboler.LØVE));
        }
        kopp.setSpareTerninger(spar);
        assertEquals(10, GiPoeng.giPoeng(12, kopp));
        spar.remove(0);
        kopp.setSpareTerninger(spar);
        assertEquals(0, GiPoeng.giPoeng(12, kopp));
    }

    /**
     * Test kopp.
     */
    @Test
    public void testKopp(){
        kopp.trillAlleTerninger();
        assertTrue(kopp.getTerninger().size() == 5);
        assertTrue(kopp.getSpareTerninger().size() == 0);
    }

    /**
     * Test terning.
     */
    @Test
    public void testTerning(){
        Terning terning = new Terning();
        for (int i = 0; i < 10; i++){
            terning.trill();
            assertTrue(symbolTerning(terning));
        }
    }

    /**
     * Symbol terning boolean.
     *
     * @param terning the terning
     * @return the boolean
     */
    public boolean symbolTerning(Terning terning){
        Symboler.EnumSymboler symbol = terning.getSymbol();
        return (symbol == Symboler.EnumSymboler.HVAL ||
                symbol == Symboler.EnumSymboler.GRIS ||
                symbol == Symboler.EnumSymboler.PANDA ||
                symbol == Symboler.EnumSymboler.ELEFANT ||
                symbol == Symboler.EnumSymboler.LØVE ||
                symbol == Symboler.EnumSymboler.SLANGE);
    }
}
