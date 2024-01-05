import java.util.Scanner;

// Interface Lutador
interface Lutador {
    void atacar(Lutador oponente);

    void defender();

    int obterVida();
}


class Ironman implements Lutador {
    private int vida;

    public Ironman() {
        this.vida = 100;
    }

    @Override
    public void atacar(Lutador oponente) {

        System.out.println("Ironman ataca!");
        oponente.defender();
    }

    @Override
    public void defender() {

        System.out.println("Ironman defende! Recebeu pouco dano.");
        this.vida -= 20;
    }

    @Override
    public int obterVida() {
        return vida;
    }
}


class Hulk implements Lutador {
    private int vida;

    public Hulk() {
        this.vida = 100;
    }

    @Override
    public void atacar(Lutador oponente) {

        System.out.println("Hulk ataca!");
        oponente.defender();
    }

    @Override
    public void defender() {

        System.out.println("Hulk defende! Recebeu dano.");
        this.vida -= 45;
    }

    @Override
    public int obterVida() {
        return vida;
    }
}


class Thor implements Lutador {
    private int vida;

    public Thor() {
        this.vida = 100;
    }

    @Override
    public void atacar(Lutador oponente) {

        System.out.println("Thor ataca!");
        oponente.defender();
    }

    @Override
    public void defender() {

        System.out.println("Thor defende! Recebeu muito dano.");
        this.vida -= 50;
    }

    @Override
    public int obterVida() {
        return vida;
    }
}


public class SuperHerois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Lutador lutador1 = new Ironman();
        Lutador lutador2 = new Hulk();
        Lutador lutador3 = new Thor();

        System.out.println("Escolhe dois Avengers para lutar:");
        System.out.println("1. IronMan");
        System.out.println("2. Hulk");
        System.out.println("3. Thor");
        System.out.print("Escolher um Avenger para lutar (1, 2 ou 3): ");
        int escolha1 = scanner.nextInt();

        System.out.print("Escolher um Avenger para lutar (1, 2 ou 3): ");
        int escolha2 = scanner.nextInt();


        while (escolha1 == escolha2) {
            System.out.println("Escolher dois Avengers diferentes para lutar!");
            System.out.print("Escolher um Avenger para lutar: ");
            escolha2 = scanner.nextInt();
        }


        Lutador lutadorEscolhido1, lutadorEscolhido2;

        if (escolha1 == 1) {
            lutadorEscolhido1 = lutador1;
        } else if (escolha1 == 2) {
            lutadorEscolhido1 = lutador2;
        } else {
            lutadorEscolhido1 = lutador3;
        }

        if (escolha2 == 1) {
            lutadorEscolhido2 = lutador1;
        } else if (escolha2 == 2) {
            lutadorEscolhido2 = lutador2;
        } else {
            lutadorEscolhido2 = lutador3;
        }


        while (lutadorEscolhido1.obterVida() > 0 && lutadorEscolhido2.obterVida() > 0) {
            System.out.println("Avenger 1 - Escolhe 1 para atacar, 2 para defesa");
            int acaoLutador1 = scanner.nextInt();

            if (acaoLutador1 == 1) {
                lutadorEscolhido1.atacar(lutadorEscolhido2);
            } else {
                lutadorEscolhido1.defender();
            }

            System.out.println("Avenger 2 - Escolhe 1 para atacar, 2 para defesa");
            int acaoLutador2 = scanner.nextInt();

            if (acaoLutador2 == 1) {
                lutadorEscolhido2.atacar(lutadorEscolhido1);
            } else {
                lutadorEscolhido2.defender();
            }


            System.out.println("\nVida restante do Avenger 1: " + lutadorEscolhido1.obterVida());
            System.out.println("Vida restante do Avenger 2: " + lutadorEscolhido2.obterVida() + "\n");
        }


        if (lutadorEscolhido1.obterVida() <= 0 && lutadorEscolhido2.obterVida() <= 0) {
            System.out.println("A luta terminou, ficaram empatados!");
        } else if (lutadorEscolhido1.obterVida() <= 0) {
            System.out.println("O Avenger 2 venceu a luta!");
        } else {
            System.out.println("O Avenger 1 venceu a luta!");
        }

        scanner.close();
    }
}
