import java.util.Scanner;

public class CalcularPeso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Peso da Terra (kg): ");
        double pesoTerra = scanner.nextDouble();


        double gravidadeLua = 0.17;


        double CalcularPeso = (pesoTerra * gravidadeLua) / 1.0;

        System.out.println("O peso equivalente na Lua é: " + CalcularPeso+ " kg");

        scanner.close();
    }
}
