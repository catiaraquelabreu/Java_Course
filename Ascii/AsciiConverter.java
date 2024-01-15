import java.util.Scanner;

public class AsciiConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type a phrase and text '.' to stop): ");
        String sentence = scanner.nextLine();

        int changes = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);

            if (Character.isUpperCase(character)) {
                character = Character.toLowerCase(character);
                changes++;
            } else if (Character.isLowerCase(character)) {
                character = Character.toUpperCase(character);
                changes++;
            }

            result.append(character);
        }

        System.out.println("Output: " + result.toString());
        System.out.println("Number of changes: " + changes);

        scanner.close();
    }
}
