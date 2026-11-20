import java.util.ArrayList;

public class Human extends Rase {

    public Human(String klasse, String navn, int level) {
        super(klasse, navn, level, new ArrayList<>());
        this.egenskaper.add("resourceful");
        this.egenskaper.add("skillful");
        this.egenskaper.add("versatile");
    }

}