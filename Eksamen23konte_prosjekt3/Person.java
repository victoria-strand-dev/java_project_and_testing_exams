import java.util.ArrayList;

public class Person {
    private String person_nr;
    private String navn;
    private ArrayList<Kjoretoy> kjoretoy = new ArrayList<>();

    public Person(String person_nr, String navn) {
        this.person_nr = person_nr;
        this.navn = navn;
    }

    public void legg_til_kjoretoy(Kjoretoy nyttKjoretoy) {
        kjoretoy.add(nyttKjoretoy);
    }

    public String getPersonNr() {return person_nr;}
    public ArrayList<Kjoretoy> getKjoretoy() {return kjoretoy;}

    @Override
    public String toString() {
        return person_nr + " " + navn;
    }
}