import java.util.Scanner;

public class DnD_Character {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rase
        String[] raser = {"Elf", "Human"};

        System.out.println("\nChoose the race for your character:");
        for (int i = 0; i < raser.length; i++) {
            System.out.println(raser[i] + " (" + (i + 1) + ")");
        }

        System.out.print("\nEnter your race: ");
        int raceOption = scanner.nextInt(); //raceOption kunne like så godt hett i
        scanner.nextLine();

        String rase = (raceOption >= 1 && raceOption <= raser.length)
            ? raser[raceOption - 1] //velger 1 = raser[0] = Elf
            : "Human"; // default fallback if user enters invalid number


        //Klasse
        String[] klasser = {"Wizard", "Druid", "Fighter", "Rogue", "Cleric", "Barbarian", 
        "Bard", "Monk", "Paladin", "Ranger", "Sorcerer", "Warlock", "Artificer"};

        System.out.println("\nAvailable classes:");
        for (int i = 0; i < klasser.length; i++) {
            System.out.println(klasser[i] + " (" + (i + 1) + ")");
        }        

        System.out.print("\nEnter your class: ");
        int klasseOption = scanner.nextInt();
        scanner.nextLine();

        String klasse = (klasseOption >= 1 && klasseOption <= klasser.length)
            ? klasser[klasseOption - 1]
            : "Commoner";


        //Navn
        System.out.print("\nEnter your character's name: ");
        String navn = scanner.nextLine();
        
        //Level
        System.out.print("\nEnter your character's level: ");
        int level = scanner.nextInt();

        //Karakteren
        Rase character;
        if (rase.equals("Elf")) {
            character = new Elf(klasse, navn, level);
        } 
        else {
            character = new Human(klasse, navn, level);
        }

        //Kaller på metodene som skal kjøres
        character.skrivUtInfo();
        character.skrivUtEgenskaper();

        scanner.close();
    }
}