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
    }

    public void visAlleTerninger(){
        int index = 1;
        for (Terning t : terninger){
            System.out.println("Terning " + index + " har symbolet " + t.getSymbol());
            index++;
        }
        System.out.println();
    }

    public void sparManuel(String s){
        if (!s.equals("n")){
            String[] splittet = s.split(" ");
            for (String string : splittet){
                int index = Integer.parseInt(string);
                spareTerninger.add(terninger.get(index - 1));
                terninger.remove(index - 1);
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
