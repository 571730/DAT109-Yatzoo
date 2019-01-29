package no.hvl.dat109.yatzoo;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Gi poeng.
 * Brukes til å gi poeng for de forskjellige rundene
 */
public class GiPoeng {
    /**
     * Gi poeng int.
     * metoden finner ut hvilket spill som spilles
     * sjekker terningene og finner ut hvor mange poeng som skal gis
     *
     * @param runde sier hvilken runde vi er på
     * @param kopp  koppen med kontrol over alle terningene
     * @return the antall poeng som ble gitt for runden
     */
    public static int giPoeng(int runde, Kopp kopp){
        int poeng = 0;
        HashMap<Symboler.EnumSymboler, Integer> map = finnHashMap(kopp);
        if (runde <= 6){
            poeng = finnLike(kopp);
        } else if(runde == 7){
            if (treLikeFireLike(kopp, runde, map)){
                poeng = 3;
            }
        } else if( runde == 8){
            if (treLikeFireLike(kopp, runde, map)){
                poeng = 4;
            }
        } else if (runde == 9){
            if (toPar(kopp, map)){
                poeng = 4;
            }
        } else if (runde == 10){
            if (hus(kopp, map)){
                poeng = 5;
            }
        } else if(runde == 11){
            if (femUlike(kopp, map)){
                poeng = 5;
            }
        } else {
            if (yatzoo(kopp, map)){
                poeng = 10;
            }
        }
        return poeng;
    }

    /**
     * Denne metoden brukes for å telle poeng i rundene 1-6
     * her får du poeng for hver av terningene som har samme symbol
     * @param kopp
     * @return int som sier hvor mye poeng som skal gis
     */
    private static int finnLike(Kopp kopp){
        return kopp.getSpareTerninger().size();
    }

    /**
     * Sjekker som koppen oppfyller kravene om 3 like
     * @param kopp koppen
     * @param runde runden vi er på
     * @param map hashmap over terningene og dems verdier
     * @return om spilleren fikk 3 like
     */
    private static boolean treLikeFireLike(Kopp kopp, int runde, HashMap<Symboler.EnumSymboler, Integer> map){
        Map.Entry<Symboler.EnumSymboler, Integer> maxEntry = null;

        for (Map.Entry<Symboler.EnumSymboler, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return (runde == 7) ? maxEntry.getValue() >= 3 : maxEntry.getValue() >=4;
    }

    /**
     * Sjekker om spilleren fikk 2 par
     * @param kopp koppen
     * @param map hashmap med terningene og dem verdier
     * @return om du fikk 2 par
     */
    private static boolean toPar(Kopp kopp, HashMap<Symboler.EnumSymboler, Integer> map){
        //Teller antall par av terninger
        int teller = 0;
        for (Map.Entry<Symboler.EnumSymboler, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= 2 )
                teller++;
        }
        return teller >= 2;
    }

    /**
     * Sjekker om spilleren fikk hus
     * @param kopp kopp
     * @param map hashmap med alle terninger og dems verdier
     * @return om du fikk hus eller ikke
     */
    private static boolean hus(Kopp kopp, HashMap<Symboler.EnumSymboler, Integer> map){
        boolean fantTreLike = false;
        boolean fantToLike = false;

        for (Map.Entry<Symboler.EnumSymboler, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == 2 )
                fantToLike = true;
            else if(entry.getValue() == 3)
                fantTreLike = true;
        }
        return fantTreLike && fantToLike;
    }

    /**
     * Sjekker som spilleren har fått 5 ulike terninger
     * @param kopp koppen
     * @param map hashmap med alle terninger og dems verdier
     * @return om du fikk 5 ulike eller ikke
     */
    private static boolean femUlike(Kopp kopp, HashMap<Symboler.EnumSymboler, Integer> map){
        for (Map.Entry<Symboler.EnumSymboler, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= 2){
                return false;
            }
        }
        return true;
    }

    /**
     * Sjekker om alle terninger har samme verdi
     * @param kopp koppen
     * @param map hashmap med terningene og dems verdier
     * @return om du fikk yatzoo eller ikke
     */
    private static boolean yatzoo(Kopp kopp, HashMap<Symboler.EnumSymboler, Integer> map){
        return map.containsValue(5);
    }

    private static HashMap<Symboler.EnumSymboler, Integer> finnHashMap(Kopp kopp){
        HashMap<Symboler.EnumSymboler, Integer> map = new HashMap<>();
        for (Terning t : kopp.getSpareTerninger()){
            if (!map.containsKey(t.getSymbol())){
                map.put(t.getSymbol(), 1);
            } else {
                int verdi = map.get(t.getSymbol());
                map.put(t.getSymbol(), verdi + 1);
            }
        }
        return map;
    }
}
