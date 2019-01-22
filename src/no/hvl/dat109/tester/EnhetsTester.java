package no.hvl.dat109.tester;


import no.hvl.dat109.yatzoo.Symboler;
import no.hvl.dat109.yatzoo.Terning;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EnhetsTester {

    @Before
    public final void setup(){

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
