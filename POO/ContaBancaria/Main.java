import java.util.Scanner;

class ContaBancaria {

    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String nomeTitular, double saldoInicial) {

        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void levantar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Levantamento de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de levantamento inválido.");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }


    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criação de conta bancária:");
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Saldo: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nomeTitular, saldoInicial);

        System.out.println("\nConta criada com sucesso!");
        System.out.println("Informações da conta:");
        System.out.println("Nome do titular: " + conta.getNomeTitular());
        System.out.println("Saldo: " + conta.verificarSaldo());


        System.out.print("\nValor para depósito: ");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        System.out.print("Valor para levantamento: ");
        double valorLevantamento = scanner.nextDouble();
        conta.levantar(valorLevantamento);

        System.out.println("\nSaldo atualizado: " + conta.verificarSaldo());

        scanner.close();
    }
}
