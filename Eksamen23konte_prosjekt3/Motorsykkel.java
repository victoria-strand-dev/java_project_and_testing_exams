public class Motorsykkel extends Kjoretoy {
    private boolean sidevogn;

    public Motorsykkel(String reg_nr, String merke, String modell, Person eier, boolean sidevogn) {
        super(reg_nr, merke, modell, eier);
        this.sidevogn = sidevogn;
    }
}