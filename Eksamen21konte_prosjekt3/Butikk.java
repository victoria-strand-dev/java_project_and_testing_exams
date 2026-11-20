import java.util.ArrayList;

public class Butikk {
    private String navn;
    private ArrayList<Kunde> kundeliste = new ArrayList<>();
    private ArrayList<Vare>  varelager = new ArrayList<>();

    public Butikk(String navn) {
        this.navn = navn;
    }

    public void legg_til_kunde(
        String type,             // "privat" eller "bedrift"
        String kunde_nr,
        String adresse,
        String telefon_nr,
        String navn_eller_firmanavn,
        String fodselsdato_eller_orgnr
    ) {
        if (type.equals("privat")) {
            Privatkunde p = new Privatkunde(kunde_nr, adresse, telefon_nr, navn_eller_firmanavn, fodselsdato_eller_orgnr);
            kundeliste.add(p);
        } else if (type.equals("bedrift")) {
            Bedriftskunde b = new Bedriftskunde(kunde_nr, adresse, telefon_nr, fodselsdato_eller_orgnr, navn_eller_firmanavn);
            kundeliste.add(b);
        } else {
            System.out.println("Ugyldig kundetype. Bruk 'privat' eller 'bedrift'.");
        }
    }

    public void slett_kunde(String kunde_nr) {
        for (Kunde k : kundeliste) {
            if (k.getKundeNr().equals(kunde_nr)) {
                kundeliste.remove(k);
            }
        }
    }

    public void skriv_ut_alle() {
        for (Kunde k : kundeliste) {
            System.out.println(k);
        }
    }

    public void legg_til_vare(String vare_id, String navn, double pris, int beholdning) {
        Vare nyVare = new Vare(vare_id, navn, pris, beholdning);
        varelager.add(nyVare);
    }

    public void legg_inn_bestilling(String kunde_nr, int vare_id, int antall) {
        Kunde kunde = null;
        Vare vare = null;

        for (Kunde k : kunder) {
            if (k.getKundeNr().equals(kunde_nr)) {
                kunde = k;
                break;
            }
        }
        for (Vare v : varelager) {
            if (v.getVareID().equals(vare_id)) {
                vare = v;
                break;
            }
        }

        if (kunde != null && vare != null) {
            try {
                vare.oppdater_beholdning(-antall);
                System.out.println("Kunden med kundenummer " + kunde_nr 
                + " har bestilt " + antall + vare.getVareNavn() + "er.");
            } catch (NegativBeholdningException e) {
                System.out.println("Feil: " + e.getMessage());
            }
        } else {
            System.oot.println("Kunde eller vare finnes ikke.");
        }
    }

    public ArrayList<Kunde> getKundeListe() {
        return kundeliste;
    }

}