import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class KjoretoyRegister {
    private ArrayList<Person> eiere = new ArrayList<>();

    public void legg_til_person(String person_nr, String navn) {
        Person nyPerson = new Person(person_nr, navn); //personer kan også eie kjøretøy??
        eiere.add(nyPerson);
    }

    public void legg_til_bil(String person_nr, String reg_nr, String merke, String modell, int antall_seter) throws PersonNrFinnesIkkeException {
        for (Person p : eiere) {
            if (p.getPersonNr().equals(person_nr)) {
                Bil nyBil = new Bil(reg_nr, merke, modell, p, antall_seter);
                p.legg_til_kjoretoy(nyBil);
                return;
            }
        }
        throw new PersonNrFinnesIkkeException("Det finnes ingen eiere med dette personnummeret");
    }

    public void legg_til_motorsykkel(String person_nr, String reg_nr, String merke, String modell, boolean sidevogn) throws PersonNrFinnesIkkeException {
        for (Person p : eiere) {
            if (p.getPersonNr().equals(person_nr)) {
                Motorsykkel nyMotorsykkel = new Motorsykkel(reg_nr, merke, modell, p, sidevogn);
                p.legg_til_kjoretoy(nyMotorsykkel);
                return;
            }
        }
        throw new PersonNrFinnesIkkeException("Det finnes ingen eiere med dette personnummeret");
    }

    public void beregn_avgifter(double bilAvgift, double motorsykkelAvgift) {
        File fil = new File("Avgiftsregister.txt");
        double totaleAvgifter = 0.0;
        try {
            FileWriter ut = new FileWriter(fil);
            for (Person p : eiere) {
                double avgift = 0.0;
                for (Kjoretoy k : p.getKjoretoy()) { 
                    if (k instanceof Bil) {
                        avgift += bilAvgift; 
                    } 
                    else if (k instanceof Motorsykkel) {
                        avgift += motorsykkelAvgift;
                    }
                }
                ut.write(p + " skal betale " + avgift + "kr.\n");
                totaleAvgifter += avgift;
            }
            ut.write("\nTotalt skal det betales " + totaleAvgifter + "kr.");
            ut.close();
        } catch (Exception e) {
            System.out.println("Kunne ikke skrive til fil: " + e.getMessage());
        }
    }

    public void sorter_personregister() {
        eiere.sort((a,b) -> Integer.compare(a.getKjoretoy().size(), b.getKjoretoy().size()));
        for (Person e : eiere) {
            System.out.println(e);
        }
    }
}
