public abstract class Kjoretoy {
    private String reg_nr;
    private String merke;
    private String modell;
    private Person eier; 

    public Kjoretoy(String reg_nr, String merke, String modell, Person eier) {
        this.reg_nr = reg_nr;
        this.merke = merke;
        this.modell = modell;
        this.eier = eier;
    }
}