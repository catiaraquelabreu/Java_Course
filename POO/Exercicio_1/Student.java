import java.util.Scanner; // importar scanner

public class Student {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt para o utilizador inserir o nome do estudante com a variável do tipo string
        System.out.print("Por favor, insira o nome do estudante: ");
        String nome = in.nextLine();

        // Prompt para o utilizador inserir a idade do estudante com a variável do tipo int
        System.out.print("Por favor, insira a idade do estudante: ");
        int idade = in.nextInt();

        // Prompt para o utilizador inserir a nota do exame do estudante com a variável do tipo float
        System.out.print("Por favor, insira a nota do estudante no exame: ");
        float nota = in.nextFloat();

        // Vai fazer display aos dados fornecidos do estudante
        System.out.println("Nome do estudante: " + nome);
        System.out.println("Idade do estudante: " + idade);
        System.out.println("Nota do estudante no exame: " + nota);
    }
}

