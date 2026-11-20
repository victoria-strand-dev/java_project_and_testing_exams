import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Eksamen23 {
    /*MAIN-KLASSE*/
    public static void main(String[] args) {
        Konto brukskonto1 = new BruksKonto("90128967340", rente);
        Konto sparekonto1 = new SpareKonto("82715263425", rente);

        sparekonto1.innskudd(100000);
        brukskonto1.innskudd(100000);

        for (i = 0; i < 7; i++) {
            sparekonto1.uttak(10000);
            brukskonto1.uttak(10000);
            for (transaksjonsliste.instanceof(SpareKonto)) {
                Transaksjon nyTransaksjon1 = transaksjonsliste.indexOf(i);
                System.out.println(nyTransaksjon1);
            }
            for (transaksjonsliste.instanceof(BruksKonto)) {
                Transaksjon nyTransaksjon2 = transaksjonsliste.indexOf(i);
                System.out.println(nyTransaksjon2);
            }
        }

        run() {
            Scanner input = new Scanner(System.in);
            try {
                while (run) {
                    Thread thread = new MinSkriveTrad();
                    thread.minSkriveTrad();
                    thread.start()

                    System.out.print("Trykk en tast for å avslutte tråden.");
                    input.nextLine();
                    thread.interrupted();
                }
            } catch (InterruptedException e) {
                System.out.println("Tråden ble avbrutt.");
            }
            Scanner.close();
        }
    }
    /*KONTO-KLASSE*/
    public class Konto {
        private String kontoNummer;
        private double saldo = 0.0;
        private double rente;
        private double akkumulertRente = 0.0;
        private ArrayList<Transaksjon> transaksjonsliste = new ArrayList<>();

        public Konto(String kontoNummer, double rente) {
            this.kontoNummer = kontoNummer;
            this.rente = rente;
        }

        public void utforTransaksjon(double belop, String tekst) throws IkkeDekningException {
            if (belop < 0 && belop > saldo) {
                throw new IkkeDekningException("Det er ikke nok dekning på kontoen for dette beløpet.");
            }
            if (belop > 0) {
                Transaksjon nyTransaksjon = new Transaksjon(belop, LocalDate.now().toString(), tekst);
                transaksjonsliste.add(nyTransaksjon);
            }
        }

        public void innskudd(double belop) throws IkkeDekningException, IkkeMuligMedNegativtBelopException {
            if (belop < 0) {
                throw new IkkeMuligMedNegativtBelopException("Ikke mulig med negativt beløp.");
            }
            if (belop > 0) {
                utforTransaksjon(belop, "Innskudd");
            }
        }

        public void uttak() throws IkkeDekningException, IkkeMuligMedNegativtBelopException {
            if (belop < 0) {
                throw new IkkeMuligMedNegativtBelopException("Ikke mulig med negativt beløp.");
            }
            if (belop > 0) {
                utforTransaksjon(belop, "Uttak");
                saldo += belop*-1;
            }
        }

        public void gebyr(double belop) throws IkkeDekningException, IkkeMuligMedNegativtBelopException {
            if (belop < 0) {
                throw new IkkeMuligMedNegativtBelopException("Ikke mulig med negativt beløp.");
            }
            if (belop > 0) {
                utforTransaksjon(belop, "Gebyr");
                saldo += belop*-1;
            }
        }

        public void beregnRenter() {
            double tempSaldo = saldo;
            if (dato.getMonthValue == maanedNaa) {
                akkumulertRente += tempSaldo*(rente/365);
                tempSaldo += (tempSaldo + akkumulertRente); 
            }
            if (!(dato.getMonthValue == maanedNaa)) {
                saldo += tempSaldo;
                akkumulertRente = 0.0;
            }
            int maanedNaa = dato.getMonthValue;
        }
    }
    /*BRUKSKONTO-KLASSE*/
    public class BruksKonto extends Konto {
        public BruksKonto(String kontoNummer, double rente) {
            super(kontoNummer, 0.25);
        }
    }
    /*SPAREKONTO-KLASSE*/
    public class SpareKonto extends Konto {
        private int antallGratisUttak = 5;
        private int antallUttak = 0;

        public SpareKonto(String kontoNummer, double rente) {
            super(kontoNummer, rente);
            rente = 1.6;
        }

        @Override
        public void uttak(double belop) throws IkkeDekningException, IkkeMuligMedNegativtBelopException {
            if (belop < 0) {
                throw new IkkeMuligMedNegativtBelopException("Ikke dekning.");
            }
            if (belop > 0 && belop < 25000) {
                utforTransaksjon(belop, "Uttak");
                saldo += (belop + 250)*-1;
            }
            if (belop > 0 && belop >= 25000) {
                utforTransaksjon(belop, "Uttak");
                saldo += (belop + belop*0.01)*-1;
            }
        }
    }
    /*TRANSAKSJON-KLASSE*/
    public class Transaksjon {
        private double belop;
        private Dato dato;
        private String tekst;

        public Transaksjon(double belop, Dato dato, String tekst) {
            this.belop = belop;
            this.dato = dato;
            this.tekst = tekst;
        }

        public String toString() {
            return "Beløp: " + belop + " | Dato: " + dato + " | Tekst: " + tekst;
        }
    }
    /*DATO-KLASSE*/
    public class Dato {
        private int dag = dato.getDayOfMotnh();
        private int maaned = dato.getMonthValue();
        private int aar = dato.getYear();

        public Dato() {

        }
    }

    /*IKKEDEKNING-KLASSE*/
    public class IkkeDekningException extends Exception {
        public IkkeDekningException(String message) {
            super(message);
        }
    }
    /*NEGATIVTBELØP-KLASSE*/
    public class IkkeMuligMedNegativtBelopException extends Exception {
        public IkkeMuligMedNegativtBelopException(String message) {
            super(message);
        }
    }

    /*TRÅD-KLASSE*/
    public class MinSkriveTrad implements Runnable {
        public void minSkriveTrad() {
            for (Konto k : kontoListe) { //Må lages
                k.beregnRenter();
            }
            thread.sleep(1000*60*60*24);
        }
    }
}