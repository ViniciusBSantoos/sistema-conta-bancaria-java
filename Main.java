import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criando conta com valor inicial
        System.out.print("Digite o valor inicial da conta: ");
        double depositoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(depositoInicial);

        int opcao;

        do {
            // MENU
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    conta.consultarChequeEspecial();
                    break;

                case 3:
                    System.out.print("Digite o valor para depositar: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;

                case 4:
                    System.out.print("Digite o valor para sacar: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;

                case 5:
                    System.out.print("Digite o valor do boleto: ");
                    double boleto = scanner.nextDouble();
                    conta.pagarBoleto(boleto);
                    break;

                case 6:
                    conta.verificarUsoChequeEspecial();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}