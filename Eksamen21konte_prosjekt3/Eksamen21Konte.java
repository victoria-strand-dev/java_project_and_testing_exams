public class Eksamen21Konte {
    public static void main(String[] args) {

        Butikk butikk1 = new Butikk("Meny borre");

        butikk1.legg_til_kunde(new Privatkunde(1234, "raveien 2", "90785643", "Kari", "010304"));
        butikk1.legg_til_kunde(new Bedriftskunde(7654, "kopstadkrysset 5", "63927638", "019283", "Kaia"));
        butikk1.legg_til_kunde(new Privatkunde(5432, "braveien 6", "87452309", "Turid", "091247"));
        butikk1.legg_til_kunde(new Bedriftskunde(8305, "snegleveien 12", "71715252", "876543", "Marit"));

        butikk1.slett_kunde(1234);

        butikk1.skriv_ut_alle();


        Runnable minTråd = new MinSkriveTråd(butikk1.getKundeListe());
        Thread thread = new Thread(minTråd);
        thread.start();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Trykk en tast for å avslutte.");
        input.nextLine();
        thread.interrupted();

        System.out.println("Main er ferdig.");


    }
}