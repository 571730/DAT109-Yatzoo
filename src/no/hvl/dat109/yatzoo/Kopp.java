package no.hvl.dat109.yatzoo;

import java.util.ArrayList;

/**
 * Koppen skal holde alle terninger som skal kastes
 * Den vil også passe på hvilke terniger som skal kastes på nytt osv.
 */
public class Kopp {
    private ArrayList<Terning> terninger;
    private ArrayList<Terning> spareTerninger;

    /**
     * Instantiates a new Kopp.
     */
    public Kopp() {
        resetKopp();
    }

    /**
     * Trill alle terninger.
     */
    public void trillAlleTerninger(){
        for(Terning t : terninger){
            t.trill();
        }
        visTerninger("s");
        visTerninger("n");
    }

    /**
     * Viser alle terninger du har trillet og de du har spart
     * alt ettersom og metoden blir gitt strengen s, eller ikke
     * @param s strenges skal være s eller ikke
     */

    private void visTerninger(String s){
        ArrayList<Terning> arr;
        if (s.equals("s")){
            arr = spareTerninger;
            s = "Dine sparte terninger";
        } else {
            arr = terninger;
            s = "Du trillet";
        }
        System.out.println("--- " + s + " ---");
        int index = 1;
        for (Terning t : arr){
            System.out.print(index + ": " + t.getSymbol() + "  ");
            index++;
        }
        System.out.println("\n");
    }

    /**
     * Spar manuel.
     * lar brukeren manuelt velge hvilken terninger som skal spares
     *
     * @param s strengen som sier noe om hvilke terninger som skal spares
     */
    public void sparManuel(String s) throws NumberFormatException, NullPointerException{
        if (s != null && !s.isEmpty()){
            String[] splittet = s.split(" ");
            ArrayList<Terning> skalSpares = new ArrayList<>();
            ArrayList<Terning> leggesTilbake = new ArrayList<>();
            for (String string : splittet){
                if (string.contains("s")){
                    int index = Integer.parseInt(string.substring(1, 2));
                    leggesTilbake.add(spareTerninger.get(index - 1));
                } else {
                    int index = Integer.parseInt(string);
                    skalSpares.add(terninger.get(index - 1));
                }
            }
            for (Terning t : skalSpares){
                spareTerninger.add(t);
                terninger.remove(t);
            }
            for (Terning t : leggesTilbake){
                terninger.add(t);
                spareTerninger.remove(t);
            }
        }
    }

    /**
     * Spar terning.
     * Denne sparer automatisk terninger med gitte symbol
     *
     * @param symbol the symbol
     */
    public void sparTerning(Symboler.EnumSymboler symbol){
        for (Terning t : terninger){
            if (t.getSymbol() == symbol){
                spareTerninger.add(t);
                //System.out.println("Sparte på terningen " + t.getSymbol());
            }
        }
        terninger.removeIf(t -> t.getSymbol() == symbol);
    }

    /**
     * Ferdig boolean.
     * sjekker som alle terninger er spart
     *
     * @return the boolean
     */
    public boolean ferdig(){
        return terninger.size() == 0;
    }

    /**
     * Reset kopp.
     */
    public void resetKopp(){
        terninger = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            terninger.add(new Terning());
        }
        spareTerninger = new ArrayList<>();
    }

    /**
     * Gets spare terninger.
     *
     * @return the spare terninger
     */
    public ArrayList<Terning> getSpareTerninger() {
        return spareTerninger;
    }

    /**
     * Gets terninger.
     *
     * @return the terninger
     */
    public ArrayList<Terning> getTerninger() {
        return terninger;
    }
}
