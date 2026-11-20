import java.util.ArrayList;

abstract class Rase {
    String klasse;
    String navn;
    int level;
    ArrayList<String> egenskaper;

    public Rase(String klasse, String navn, int level, ArrayList<String> egenskaper) {
        this.klasse = klasse;
        this.navn = navn;
        this.level = level;
        this.egenskaper = egenskaper;
    }

    public void skrivUtEgenskaper() {
        System.out.println("\n" + navn + " has these abilities: " + String.join(", ", egenskaper));
    }

    public void skrivUtInfo() {
        System.out.println("\n" + navn + " belongs to the " + klasse + " class and is in level " + level);
    }

}