import java.util.ArrayList;

public class Elf extends Rase {

    public Elf(String klasse, String navn, int level) {
        super(klasse, navn, level, new ArrayList<>());
        this.egenskaper.add("darkvision");
        this.egenskaper.add("elven lineage");
        this.egenskaper.add("fey ancestry");
        this.egenskaper.add("keen senses");
        this.egenskaper.add("trance");
    }

}