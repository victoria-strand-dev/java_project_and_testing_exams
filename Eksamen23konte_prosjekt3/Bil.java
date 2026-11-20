public class Bil extends Kjoretoy {
    private int antall_seter;

    public Bil(String reg_nr, String merke, String modell, Person eier, int antall_seter) {
        super(reg_nr, merke, modell, eier);
        this.antall_seter = antall_seter;
    }
}