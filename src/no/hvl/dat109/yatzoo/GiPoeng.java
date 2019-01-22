package no.hvl.dat109.yatzoo;

public class GiPoeng {
    public static int giPoeng(int runde, Kopp kopp){
        int poeng = 0;
        if (runde <= 6){
            poeng = finnLike(kopp);
        }
        return poeng;
    }

    private static int finnLike(Kopp kopp){
        return kopp.getSpareTerninger().size();
    }
}
