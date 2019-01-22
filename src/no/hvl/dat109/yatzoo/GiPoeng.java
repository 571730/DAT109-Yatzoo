package no.hvl.dat109.yatzoo;

import java.util.HashMap;
import java.util.Map;

public class GiPoeng {
    public static int giPoeng(int runde, Kopp kopp){
        int poeng = 0;
        if (runde <= 6){
            poeng = finnLike(kopp);
        } else if(runde == 7){
            if (treLike(kopp)){
                poeng = 3;
            }
        }
        return poeng;
    }

    private static int finnLike(Kopp kopp){
        return kopp.getSpareTerninger().size();
    }

    private static boolean treLike(Kopp kopp){
        HashMap<Symboler.EnumSymboler, Integer> map = new HashMap<>();
        for (Terning t : kopp.getSpareTerninger()){
            if (!map.containsKey(t.getSymbol())){
                map.put(t.getSymbol(), 1);
            } else {
                int verdi = map.get(t.getSymbol());
                map.put(t.getSymbol(), verdi + 1);
            }
        }
        Map.Entry<Symboler.EnumSymboler, Integer> maxEntry = null;

        for (Map.Entry<Symboler.EnumSymboler, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue() >= 3;
    }
}
