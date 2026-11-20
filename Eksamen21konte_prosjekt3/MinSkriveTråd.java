import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;

public class MinSkriveTråd implements Runnable {
    private ArrayList<Kunde> kundeliste;

    public MinSkriveTråd(ArrayList<Kunde> kundeliste) {
        this.kundeliste = kundeliste;
    }

    public void run() {
        try {
            while (true) {
                skrivTilFil();
                Thread.sleep(5000); // 5 sekunder pause
            }
        } catch (InterruptedException e) {
            System.out.println("Tråden ble stoppet.");
        }
    }

    private void skrivTilFil() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("bursdag.txt"))) {
            String dagensDato = get_date();
            for (Kunde k : kundeliste) {
                if (k instanceof Privatkunde p) {
                    if (p.getFodselsdato().equals(dagensDato)) {
                        pw.println("Gratulerer med dagen, " + p.getNavn() + "!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Feil under skriving til fil: " + e.getMessage());
        }
    }

    private String get_date() {
        LocalDate nå = LocalDate.now();
        int dag = nå.getDayOfMonth();
        int måned = nå.getMonthValue();
        int år = nå.getYear() % 100;

        return String.format("%02d%02d%02d", dag, måned, år);
    }

    
}
