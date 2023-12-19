import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("1. Create a new student");
            System.out.println("2. Display information of a student");


            System.out.print("Option(1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Student newStudent = createStudent(scanner);
                    students.add(newStudent);
                    System.out.println("Student registered successfully!");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Please register a student first, no students found.");
                    } else {
                        displayStudentInformation(scanner, students);
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static Student createStudent(Scanner scanner) {
        System.out.print("Enter student's name (please don't use special characters): ");
        String name = scanner.nextLine();

        System.out.print("Student's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Student's course: ");
        String course = scanner.nextLine();

        System.out.print("Student's registration number: ");
        String registrationNumber = scanner.nextLine();

        return new Student(name, age, course, registrationNumber);
    }

    private static void displayStudentInformation(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter student's name: ");
        String nameToSearch = scanner.nextLine();

        boolean studentFound = false;
        for (Student student : students) {
            if (student.getName().equals(nameToSearch)) {
                student.displayInformation();
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Ups, student not found.");
        }
    }
}
