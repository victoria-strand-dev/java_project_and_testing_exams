public class Kunde {
    private int kunde_nr;
    private String adresse;
    private String telefon_nr;

    public Kunde(String kunde_nr, String adresse, String telefon_nr) {
        this.kunde_nr = kunde_nr;
        this.adresse = adresse;
        this.telefon_nr = telefon_nr;
    }

    public String getKundeNr() {return kunde_nr;}

    @Override
    public String toString() {
        return "Kundenummer: " + kunde_nr + " | Adresse: " + adresse + " | Telefonnummer: " + telefon_nr;
    }
}