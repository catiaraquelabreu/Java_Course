import java.util.Scanner;

public class AdivinharNumero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroAleatorio = (int) (Math.random() * 100 + 1);

        System.out.println("Bem-vindo, tente adivinhar o número entre 1 e 100.");
        System.out.println("Digite 'off' a qualquer momento para sair do jogo.");

        int numeroTentativas = 10;
        int tentativasFeitas = 0;

        while (numeroTentativas > 0) {
            System.out.println("Tem " + numeroTentativas + " tentativa(s) restante(s).");
            System.out.print("Adivinhe o número (ou 'off' para sair): ");
            String palpite = scanner.next();
            tentativasFeitas++;

            if (palpite.equalsIgnoreCase("off")) {
                System.out.println("Ohhh :( Saiu do jogo.");
                break;
            }

            try {
                int numeroPalpite = Integer.parseInt(palpite);
                if (numeroPalpite == numeroAleatorio) {
                    System.out.println("Parabéns! Acertou o número após " + tentativasFeitas + " tentativa(s)!");
                    break;
                } else if (numeroPalpite < numeroAleatorio) {
                    System.out.println("Escolha um número maior.");
                } else {
                    System.out.println("Escolha um número menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Digite um número válido ou 'off' para sair.");
            }

            numeroTentativas--;
        }

        if (numeroTentativas == 0) {
            System.out.println("Acabaram as tentativas! O número era: " + numeroAleatorio);
        }

        scanner.close();
    }
}
