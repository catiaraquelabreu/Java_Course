public class Collatz {

    public static void main(String[] args) {
        int numeroEscolhido = 1251;
        System.out.println("O numero escolhido para o exercicio: " + numeroEscolhido );
        collatz(numeroEscolhido);
    }

    public static void collatz(int numero) {
        System.out.print(numero + " ");

        while (numero != 1) {
            if (numero % 2 == 0) {
                numero /= 2;
            } else {

                numero = 3 * numero + 1;
            }
            System.out.print(numero + " ");
        }
    }
}
