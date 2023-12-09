import java.util.Scanner;

public class IslandExplorer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Shelby Island, a mysterious place full of adventures.");
        System.out.println("Here you can find a great treasure but be careful, you need to make good choices along your journey.");
        System.out.println("Let's play and have fun!");

        exploreIsland(scanner);
    }

    public static void exploreIsland(Scanner scanner) {
        boolean activeGame = true;

        while (activeGame) {
            System.out.println("\nYou've found yourself with 3 paths to choose. Choose wisely!");
            System.out.println("1. Enter the jungle");
            System.out.println("2. Cross the bridge");
            System.out.println("3. Dwell into the cavern");
            System.out.println("4. Quit and exit the game");
            System.out.print("Make a choice (1, 2, 3, or 4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exploreJungle(scanner);
                    break;
                case 2:
                    crossBridge(scanner);
                    break;
                case 3:
                    exploreCave(scanner);
                    break;
                case 4:
                    System.out.println("\nYou decided to quit the game. Until next time!");
                    activeGame = false;
                    break;
                default:
                    System.out.println("Invalid Option. Choose 1, 2, 3, or 4");
            }
        }
    }

    public static void exploreJungle(Scanner scanner) {
        System.out.println("\nYou enter the jungle and face yourself with 2 roads.");
        System.out.println("1. Follow the road on the left");
        System.out.println("2. Follow the road on the right");
        System.out.print("Which path will you choose? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nYou found a safe path and can continue your journey.");
            continueJungle(scanner);
        } else if (choice == 2) {
            System.out.println("\nOh no! A wild animal! You managed to escape, but got injured.");
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            exploreJungle(scanner);
        }
    }

    public static void crossBridge(Scanner scanner) {
        System.out.println("\nYou approach an unstable bridge.");
        System.out.println("1. Try to cross it carefully");
        System.out.println("2. Look for another path");
        System.out.print("What will you do? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nYou successfully cross the bridge and continue your journey.");
            continueJungle(scanner);
        } else if (choice == 2) {
            System.out.println("\nYou look for another path and end up back at the beginning.");
            exploreIsland(scanner);
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            crossBridge(scanner);
        }
    }

    public static void exploreCave(Scanner scanner) {
        System.out.println("\nYou enter a dark cave.");
        System.out.println("1. Light a torch and explore");
        System.out.println("2. Go back outside");
        System.out.print("What will you do? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nWith the torch lit, you find a way forward.");
            continueJungle(scanner);
        } else if (choice == 2) {
            System.out.println("\nYou decide to go back outside of the cave.");
            exploreIsland(scanner);
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            exploreCave(scanner);
        }
    }

    public static void continueJungle(Scanner scanner) {
        System.out.println("\nYou continue your journey and find a treasure!");
        System.out.println("Inside the treasure, there are two mysterious items.");
        System.out.println("1. Take the shining sword");
        System.out.println("2. Take the ancient map");
        System.out.print("Which item will you choose? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nYou take the shining sword and feel more confident.");
            continueWithSword(scanner);
        } else if (choice == 2) {
            System.out.println("\nYou take the ancient map and try to decipher its meaning.");
            continueWithMap(scanner);
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            continueJungle(scanner);
        }
    }

    public static void continueWithSword(Scanner scanner) {
        System.out.println("\nWith the sword in hand, you venture further into the jungle.");
        System.out.println("As you move forward, you encounter a group of bandits!");
        System.out.println("1. Fight the bandits");
        System.out.println("2. Try to sneak away");
        System.out.print("What will you do? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nYou bravely fight with the sword and defeat the bandits.");
            happyEnding();
        } else if (choice == 2) {
            System.out.println("\nYou bravely fight with the sword and defeat the bandits.");
            happyEnding();
        } else if (choice == 2) {
            System.out.println("\nYou attempt to sneak away, but the bandits capture you.");
            sadEnding();
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            continueWithSword(scanner);
        }
    }

    public static void continueWithMap(Scanner scanner) {
        System.out.println("\nYou decide to follow the map to find the treasure.");
        System.out.println("On the way, you encounter a dangerous maze.");
        System.out.println("1. Attempt to navigate through the maze");
        System.out.println("2. Go back and choose another path");
        System.out.print("What will you do? (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nYou successfully navigate through the maze and reach the treasure!");
            happyEnding();
        } else if (choice == 2) {
            System.out.println("\nYou decide to go back and choose another path.");
            exploreIsland(scanner);
        } else {
            System.out.println("Invalid Option. Choose 1 or 2");
            continueWithMap(scanner);
        }
    }

    public static void happyEnding() {
        System.out.println("\nCongratulations! You've found the treasure and had a great adventure!");
        System.out.println("You've found the legendary treasure and are now known as the bravest explorer of the island.");
        System.out.println("End of the journey!");
        System.exit(0);
    }

    public static void sadEnding() {
        System.out.println("\nYou were captured by the bandits. Your journey comes to an unhappy end.");
        System.out.println("End of the journey!");
        System.exit(0);
    }
}

