import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private boolean usandoChequeEspecial;
    private double valorUsadoChequeEspecial;

    // Construtor da classe
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = definirLimiteChequeEspecial(saldoInicial);
        this.usandoChequeEspecial = false;
        this.valorUsadoChequeEspecial = 0;
    }

    // Método para definir o limite do cheque especial
    private double definirLimiteChequeEspecial(double saldoInicial) {
        if (saldoInicial <= 500) {
            return 50.0;
        } else {
            return saldoInicial * 0.5; // 50% do saldo inicial
        }
    }

    // Método para consultar o saldo
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    // Método para consultar o limite do cheque especial
    public void consultarChequeEspecial() {
        System.out.println("Limite do cheque especial: R$" + limiteChequeEspecial);
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            verificarChequeEspecial();
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }

        // Cobrar taxa de 20% sobre o uso do cheque especial, se houver
        if (usandoChequeEspecial && saldo >= 0) {
            double taxa = valorUsadoChequeEspecial * 0.2;
            saldo -= taxa;
            System.out.println("Taxa de 20% (R$" + taxa + ") cobrada por uso do cheque especial.");
            valorUsadoChequeEspecial = 0; // Zera o valor usado após a cobrança
        }
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo + limiteChequeEspecial >= valor) {
                saldo -= valor;
                verificarChequeEspecial();
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Valor inválido para saque.");
        }
    }

    // Método para pagar um boleto
    public void pagarBoleto(double valor) {
        if (valor > 0) {
            if (saldo + limiteChequeEspecial >= valor) {
                saldo -= valor;
                verificarChequeEspecial();
                System.out.println("Boleto de R$" + valor + " pago com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para pagar o boleto.");
            }
        } else {
            System.out.println("Valor inválido para pagamento de boleto.");
        }
    }

    // Método para verificar se a conta está usando cheque especial
    public void verificarChequeEspecial() {
        if (saldo < 0) {
            usandoChequeEspecial = true;
            valorUsadoChequeEspecial = Math.abs(saldo); // Valor negativo convertido para positivo
            System.out.println("Você está utilizando o cheque especial.");
        } else {
            usandoChequeEspecial = false;
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializa a conta com saldo inicial
        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(saldoInicial);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso de cheque especial");
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
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto a ser pago: ");
                    double valorBoleto = scanner.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;
                case 6:
                    conta.verificarChequeEspecial();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}