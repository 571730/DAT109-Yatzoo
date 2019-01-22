package no.hvl.dat109.tester;


import no.hvl.dat109.yatzoo.GiPoeng;
import no.hvl.dat109.yatzoo.Kopp;
import no.hvl.dat109.yatzoo.Symboler;
import no.hvl.dat109.yatzoo.Terning;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnhetsTester {
    private Kopp kopp;

    @Before
    public final void setup(){
        kopp = new Kopp();
    }

    @Test
    public void testPoengLike(){
        while (kopp.getSpareTerninger().size() != 5){
            kopp.trillAlleTerninger();
            kopp.sparTerning(Symboler.EnumSymboler.ELEFANT);
        }
        assertEquals(5, GiPoeng.giPoeng(5, kopp));
    }

    @Test
    public void testKopp(){
        kopp.trillAlleTerninger();
        assertTrue(kopp.getTerninger().size() == 5);
        assertTrue(kopp.getSpareTerninger().size() == 0);
    }

    @Test
    public void testTerning(){
        Terning terning = new Terning();
        for (int i = 0; i < 10; i++){
            terning.trill();
            assertTrue(symbolTerning(terning));
        }
    }

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
