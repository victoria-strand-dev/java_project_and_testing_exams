public class Bedriftskunde extends Kunde {
    private String organisasjons_nr;
    private String kontakt_person;

    public Bedriftskunde(String kunde_nr, String adresse, String telefon_nr, String org_nr, String kontakt_person) {
        super(kunde_nr, adresse, telefon_nr);
        this.organisasjons_nr = org_nr;
        this.kontakt_person = kontakt_person;
    }

    @Override
    public String toString() {
        return super.toString() + " | Organisasjonsnummer:" + organisasjons_nr + " | Kontaktperson: " + kontakt_person;
    }
}