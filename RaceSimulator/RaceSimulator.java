import java.util.Random;
import java.util.Scanner;

class Car {
    static String winner;
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void race() {
        Random random = new Random();
        int time = random.nextInt(10) + this.speed;
        System.out.println("You chose the car " + this.name);
        System.out.println("Time taken to reach the finish line: " + time + " seconds");
        if (winner == null || time < Integer.parseInt(winner.split(":")[1])) {
            winner = this.name + ":" + time;
        }


        boolean userCarWon = winner.startsWith(this.name);

        if (userCarWon) {
            System.out.println("You chose the winning car!");
            System.out.println("Let's play again");
        } else {
            System.out.println("The winning car is: " + Car.winner.split(":")[0]);
            System.out.println("Finish line time: " + Car.winner.split(":")[1] + " seconds");
        }
    }
}

public class RaceSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] cars = {
                new Car("Porsche 911", 10),
                new Car("Mazda 787B", 12),
                new Car("Ford GT40", 9),
                new Car("Mitsubishi Eclipse 2G", 16),
                new Car("BMW M3", 8)
        };

        while (true) {
            System.out.println("Choose a car to race:");
            for (int i = 0; i < cars.length; i++) {
                System.out.println((i + 1) + ". " + cars[i].name);
            }
            System.out.println((cars.length + 1) + ". Exit");

            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= cars.length) {
                cars[choice - 1].race();
            } else if (choice == cars.length + 1) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
