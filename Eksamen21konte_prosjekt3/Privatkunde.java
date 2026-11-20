public class Privatkunde extends Kunde {
    private String navn;
    private String fodselsdato;

    public Privatkunde(int kunde_nr, String adresse, String telefon_nr, String navn, String fodselsdato) {
        super(kunde_nr, adresse, telefon_nr);
        this.navn = navn;
        this.fodselsdato = fodselsdato;
    }

    public String getFodselsdato() {return fodselsdato;}

    @Override
    public String toString() {
        return super.toString() + " | Navn: " + navn + " | Fødselsdato: " + fodselsdato;
    }
}