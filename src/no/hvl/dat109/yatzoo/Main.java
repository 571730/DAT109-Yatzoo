package no.hvl.dat109.yatzoo;

import java.util.Scanner;

/**
 * Lager spillet med noen spillere
 * Koppen og blokken lages også, dermed startes spillet
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hvor mange spillere?");
        int antallSpiller = sc.nextInt();
        sc.nextLine();
        Spiller[] spillere = new Spiller[antallSpiller];
        for (int i = 0; i < antallSpiller; i++){
            System.out.println("hva skal spiller " + i + " hete?");
            String navn = sc.nextLine();
            spillere[i] = new Spiller(navn);
            System.out.println("Spilleren " + navn + " ble opprettet!\n");
        }
        Kopp kopp = new Kopp();
        Blokk blokk = new Blokk();
        Spill spill = new Spill(spillere, blokk, kopp);
        spill.spill();
    }
}
