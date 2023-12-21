import java.util.Scanner;

class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println("O animal emite um som.");
    }
}


class Cao extends Animal {
    public Cao(String nome) {
        super(nome);
    }

    public void latir() {
        System.out.println("O/a " + nome + " está latindo.");
    }
}


class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    public void miar() {
        System.out.println("O/a " + nome + " está miando.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Dê um nome ao cão:");
        String nomeCao = scanner.nextLine();

        System.out.println("Dê um nome ao gato:");
        String nomeGato = scanner.nextLine();


        Cao meuCao = new Cao(nomeCao);
        Gato meuGato = new Gato(nomeGato);


        System.out.println();
        meuCao.emitirSom();
        meuCao.latir();
        meuGato.emitirSom();
        meuGato.miar();

        scanner.close();
    }
}
