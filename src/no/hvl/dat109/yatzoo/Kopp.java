package no.hvl.dat109.yatzoo;

import java.util.ArrayList;

/**
 * Koppen skal holde alle terninger som skal kastes
 * Den vil også passe på hvilke terniger som skal kastes på nytt osv.
 */
public class Kopp {
    private ArrayList<Terning> terninger;
    private ArrayList<Terning> spareTerninger;

    public Kopp() {
        resetKopp();
    }

    public void trillAlleTerninger(){
        for(Terning t : terninger){
            t.trill();
        }
        visTerninger("s");
        visTerninger("n");
    }


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

    public void sparManuel(String s){
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

    public void sparTerning(Symboler.EnumSymboler symbol){
        for (Terning t : terninger){
            if (t.getSymbol() == symbol){
                spareTerninger.add(t);
                //System.out.println("Sparte på terningen " + t.getSymbol());
            }
        }
        terninger.removeIf(t -> t.getSymbol() == symbol);
    }

    public boolean ferdig(){
        return terninger.size() == 0;
    }

    public void resetKopp(){
        terninger = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            terninger.add(new Terning());
        }
        spareTerninger = new ArrayList<>();
    }

    public ArrayList<Terning> getSpareTerninger() {
        return spareTerninger;
    }

    public ArrayList<Terning> getTerninger() {
        return terninger;
    }
}
