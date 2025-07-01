import java.util.Scanner;

public class CalculadoraInterativa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir o menu principal
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Realizar uma soma");
            System.out.println("2. Realizar uma subtração");
            System.out.println("3. Realizar uma multiplicação");
            System.out.println("4. Realizar uma divisão");
            System.out.println("5. Elevar um número a uma potência N");
            System.out.println("6. Sair da calculadora");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarSoma(scanner);
                    break;
                case 2:
                    realizarSubtracao(scanner);
                    break;
                case 3:
                    realizarMultiplicacao(scanner);
                    break;
                case 4:
                    realizarDivisao(scanner);
                    break;
                case 5:
                    elevarPotencia(scanner);
                    break;
                case 6:
                    System.out.println("Saindo da calculadora...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // Linha em branco para melhorar a visualização

        } while (opcao != 6);

        scanner.close();
    }

    private static void realizarSoma(Scanner scanner) {
        double resultado = 0;
        int continuar;

        do {
            System.out.print("Informe um número para somar: ");
            double numero = scanner.nextDouble();
            resultado += numero;

            System.out.println("Resultado parcial da soma: " + resultado);

            System.out.println("Deseja continuar somando?");
            System.out.println("1. Sim");
            System.out.println("2. Não (Voltar ao menu principal)");
            System.out.print("Escolha uma opção: ");
            continuar = scanner.nextInt();

        } while (continuar == 1);

        System.out.println("Resultado final da soma: " + resultado);
    }

    private static void realizarSubtracao(Scanner scanner) {
        double resultado = 0;
        int continuar;

        do {
            System.out.print("Informe um número para subtrair: ");
            double numero = scanner.nextDouble();
            if (resultado == 0) {
                resultado = numero; // Primeiro número define o valor inicial
            } else {
                resultado -= numero;
            }

            System.out.println("Resultado parcial da subtração: " + resultado);

            System.out.println("Deseja continuar subtraindo?");
            System.out.println("1. Sim");
            System.out.println("2. Não (Voltar ao menu principal)");
            System.out.print("Escolha uma opção: ");
            continuar = scanner.nextInt();

        } while (continuar == 1);

        System.out.println("Resultado final da subtração: " + resultado);
    }

    private static void realizarMultiplicacao(Scanner scanner) {
        System.out.print("Informe o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Informe o segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = num1 * num2;
        System.out.println("Resultado da multiplicação: " + resultado);
    }

    private static void realizarDivisao(Scanner scanner) {
        System.out.print("Informe o dividendo: ");
        double dividendo = scanner.nextDouble();
        System.out.print("Informe o divisor: ");
        double divisor = scanner.nextDouble();

        if (divisor == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
        } else {
            double resultado = dividendo / divisor;
            double resto = dividendo % divisor;
            System.out.println("Resultado da divisão: " + resultado);
            System.out.println("Resto da divisão: " + resto);
        }
    }

    private static void elevarPotencia(Scanner scanner) {
        System.out.print("Informe a base: ");
        double base = scanner.nextDouble();
        System.out.print("Informe o expoente: ");
        double expoente = scanner.nextDouble();

        double resultado = Math.pow(base, expoente);
        System.out.println("Resultado da potência: " + resultado);
    }
}