import java.util.Scanner;

public class CalculoIMC {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira seu peso
        System.out.print("Digite seu peso (em kg): ");
        double peso = scanner.nextDouble();

        // Solicita ao usuário que insira sua altura
        System.out.print("Digite sua altura (em metros): ");
        double altura = scanner.nextDouble();

        // Calcula o IMC
        double imc = peso / (altura * altura);

        // Exibe o IMC calculado
        System.out.printf("Seu IMC é: %.2f\n", imc);

        // Verifica a faixa do IMC e exibe a mensagem correspondente
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc > 18.5 && imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imc >= 30.0 && imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc >= 35.0 && imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade III (Mórbida)");
        }

        // Fecha o Scanner
        scanner.close();
    }
}