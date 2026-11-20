public class Vare {
    private String vare_id;
    private String navn;
    private double pris;
    private int beholdning;

    public Vare(String vare_id, String navn, double pris, int beholdning) {
        this.vare_id = vare_id;
        this.navn = navn;
        this.pris = pris;
        this.beholdning = beholdning;
    }

    public void oppdater_beholdning(int antall) throws NegativBeholdningException {
        if ((beholdning + antall) >= 0) {
            beholdning += antall;
        }
        if ((beholdning + antall) < 0) {
            throw new NegativBeholdningException("Beholdningen kan ikke være mindre enn null.");
        }
    }

    public String getVareID() {return vare_id;}
    public String getVareNavn() {return navn;}

    @Override
    public String toString() {
        return "VareID: " + vare_id + " | Navn: " + navn + " | pris: " + pris + " | Beholdning: " + beholdning;
    }

}