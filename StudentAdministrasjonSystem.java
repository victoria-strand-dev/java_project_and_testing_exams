/*Jeg har brukt flere gettere og toString() enn nødvendig.
Her har jeg gjort det underveis for å unngå at jeg 
evt. bruker noe senere som jeg har glemt å lage.*/

import java.util.ArrayList;
import java.util.Scanner;

/*HOVEDKLASSE MED MAIN*/

public class StudentAdministrasjonSystem implements Runnable {
    public static void main(String[] args) throws FeilInntastingException {
        Institutt institutt1 = new Institutt("USN", "Bakkenteigen");
        Scanner input = new Scanner(System.in);
        private final int funksjonsvalg = -1;

        Thread thread = new Thread();
        thread.start();

        run() {
            while (valg != 0) {
                institutt1.SokeFunksjonVelger(funksjonsvalg);

                if (valg < 0 || valg > 4) {
                    throw new FeilInntastingException("Du har tastet feil, velg et tall mellom 0-4");
                }
            }
        }

        System.out.print("Trykk en tast for å avslutte tråden...");
        input.nextLine();
        thread.interrupted();

        public static SokeFunksjonVelger(int funksjonsvalg) {
            SokeFunksjoner nySokFunk = new SokeFunksjoner(institutt1, funksjonsvalg, "", "", "");

            System.out.println("1. Skriv ut alle emner");
            System.out.println("2. Søk etter en student med navn");
            System.out.println("3. Finn alle studenter i et emne med en karakter (A,B,C,D,E,F)");
            System.out.println("4. Finn karakterer til en student i et emne");
            System.out.println("0. for å avslutte");
            System.out.print("Skriv inn ditt valg: ");
            valg = input.nextLine();

            try {
                switch (valg) {
                    case 1:
                        institutt1.skrivUtAlle();
                        break;
                    case 2:
                        System.out.print("Skriv inn navnet på studenten: ");
                        studentnavn = input.nextLine();
                        institutt1.finnStudent(studentnavn);
                        break;
                    case 3:
                        System.out.print("Skriv inn emnekoden: ");
                        emnekode = input.nextLine();
                        System.out.print("Skriv inn bokstavkarakteren: ");
                        bokstavkarakter = input.nextLine();
                        institutt1.finnAlleStudenteerMedKarakter(emnekode, bokstavkarakter);
                        break;
                    case 4: 
                        System.out.print("Skriv inn navnet på studenten: ");
                        studentnavn = input.nextLine();
                        System.out.print("Skriv inn emnekoden: ");
                        emnekode = input.nextLine();
                        institutt1.finnEmneKarakter(studentnavn, emnekode);
                        break;
                    case 0: 
                        System.out.println("Meny avsluttet.");
                        break;
                }
            } catch (FeilInntastingException e) {
                System.out.println("Feil: " + e.getMessage());
            }
        }
    }
}

/*KLASSER GENERELT*/

public class SokeFunksjoner {
    private Institutt institutt;
    private final int funksjonsvalg = -1; //final?
    private String studentnavn;
    private String emnenavn;
    private String bokstavkarakter;

    public SokeFunksjoner(Institutt institutt, int funksjonsvalg, String studentnavn, String emnekode, String bokstavkarakter) {
        this.institutt = institutt;
        this.funksjonsvalg = funksjonsvalg;
        this.studentnavn = studentnavn;
        this.emnekode = emnekode;
        this.bokstavkarakter = bokstavkarakter;
    }

    public void finnStudent(String studentnavn) {
        for (Student s : Institutt.getStudentListe()) {
            if (s.getPersonNavn().equals(studentnavn)) {
                System.out.println(s);
            }
        }
    }

    public void finnAlleStudenteerMedKarakter(String emnekode, String bokstavkarakter) {
        for (Emne e : Institutt.getEmneListe()) {
            if (e.getEmneKode().equals(emnekode)) {
                for (Karakter k : e.getKaraktererForEmne()) {
                    if (k.getBokstavKarakter().equals(bokstavkarakter)) {
                        System.out.println("Disse studentene har fått " + bokstavkarakter + " i " + e.getEmneNavn() + ":\n");
                        for (Student s : e.getStudenter()) {
                            if (s.getBokstavKarakter().equals(bokstavkarakter)) {
                                System.out.println(s.getPersonNavn());
                            } 
                        }
                    }  
                } 
            } 
        }
    }

    public void finnEmneKarakter(String studentnavn, String emnekode) {
        for (Emne e : Institutt.getEmneListe) {
            if (e.getEmneKode().equals(emnekode)) {
                for (Student s : e.getStudenter()) {
                    if (s.getPersonNavn().equals(studentnavn)) {
                        System.out.println(studentnavn + " fikk " + s.getBokstavKarakter() + " i " + e.getEmneNavn);
                    } 
                }
            } 
        }
    }
}

public class Person {
    private String navn;
    private String adresse;
    private String telefonnummer;

    public Person(String navn, String adr, String tlf) { //bruker jeg this. riktig?
        this.navn = navn;
        this.adresse = adr;
        this.telefonnummer = tlf;
    }

    public String getPersonNavn() {return navn;}
    public String getPersonAdr() {return adresse;}
    public String getTlf() {return telefonnummer;}

    @Override
    public String toString() { //skal det være this.adresse eller adresse eller adr?
        return "Navn: " + navn + " | Adresse: " + adresse + " | Telefonnummer: " + telefonnummer;
    }
}

public class Student extends Person {
    private String studentid;
    private ArrayList<Emne> emneListe = new ArrayList<>(); //forskjell på denne her og i institutt?

    public Student() {

    }

    public Student(String navn, String adr, String tlf, String studentid) {
        super(navn, adr, tlf);
        this.studentid = studentid;
    }

    public String getStudentID() {return studentid;}
    public ArrayList<Emne> getStudentEmneliste() {return emneListe;}

    @Override
    public String toString() {
        return super.toString() + " | StudentID: " + studentid;
    }
}

public class Ansatt extends Person {
    private String stilling;
    private boolean deltid;

    public Ansatt(String navn, String adr, String tlf, String stilling, boolean deltid) {
        super(navn, adr, tlf);
        this.stilling = stilling;
        this.deltid = deltid;
    }

    public String getStilling() {return stilling;}
    public boolean getDeltid() {return deltid;}
    public boolean setDeltid(boolean deltid) {this.deltid = deltid;}

    @Override
    public String toString() {
        return super.toString() + " | Stilling: " + stilling + " | Deltid: " + deltid; 
        //funksjon for å skrive ut ja/nei i stedet for true/false
    }
}

public class Emne {
    private String emnekode;
    private String emnenavn;
    private Ansatt foreleser;
    private ArrayList<Student> studenter = new ArrayList<>();
    private ArrayList<Karakter> karakterer = new ArrayList<>();

    public Emne(String emnekode, String emnenavn, Ansatt foreleser)  {
        this.emnekode = emnekode;
        this.emnenavn = emnenavn;
        this.foreleser = foreleser;
    }

    public String getEmneKode() {return emnekode;}
    public String getEmneNavn() {return emnenavn;}
    public Ansatt getForeleser() {return foreleser;} //nødvendig/riktig?
    public ArrayList<Student> getStudenter() {return studenter;} //riktig med ArrayList<Student>?
    public ArrayList<Karakter> getKaraktererForEmne() {return karakterer;}

    @Override
    public String toString() {
        return emnekode + " - " + emnenavn;
    }
}

public class Karakter {
    private Student student;
    private Emne emne;
    private String bokstavkarakter;

    public Karakter(Student student, Emne emne, String bokstavkarakter) {
        this.student = student;
        this.emne = emne;
        this.bokstavkarakter = bokstavkarakter;
    }

    public String getBokstavKarakter() {return bokstavkarakter;}
    public Student getKarakterStudent() {return student;}
}

public class Institutt {
    private String navn;
    private String adresse;
    private ArrayList<Ansatt> ansattListe = new ArrayList<>();
    private ArrayList<Emne> emneListe = new ArrayList<>(); //froskjell på denne og i Student?
    private ArrayList<Student> studentListe = new ArrayList<>();

    public Institutt(String navn, String adr) {
        this.navn = navn;
        this.adresse = adr;
    }

    public boolean leggTilEmne(String emnekode, String emnenavn, Ansatt foreleser) { //står boolean i UML
        for (Emne e : emneListe) {
            if (e.getEmneKode().equals(emnekode)) {
                return false;
            }
        } 
        Emne nyttEmne = new Emne(emnekode, emnenavn, foreleser);
        emneListe.add(nyttEmne);
        System.out.println("Emnet " + emnenavn + " ble lagt til.");
        return true;
    }

    public void skrivUtAlle() {
        for (Emne e : emneListe) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public boolean registrerEmneForStudent(String emnekode, String studentnavn) { //står void i UML
        Emne valgtEmne = null;
        Student valgtStudent = null;

        for (Emne e : emneListe) {
            if (e.getEmneKode.equals(emnekode)) {
                valgtEmne = e;
            }
        }
        for (Student s : studentListe) {
            if (s.getPersonNavn().equals(studentnavn)) {
                valgtStudent = s;
            }
        }
        if (valgtEmne != null && valgtStudent != null) {
            valgtEmne.getStudenter().add(valgtStudent);
            valgtStudent.getStudentEmneliste().add(valgtEmne);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getStudentListe() {return studentListe;}
    public ArrayList<Emne> getEmneListe() {return emneListe;}
}

/*KLASSER FOR TRÅD OG UNNTAK*/

public class tråd {

}

public class FeilInntastingException extends Exception {
    public FeilInntastingException(String message) {
        super(message);
    }
}