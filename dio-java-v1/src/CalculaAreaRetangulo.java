import java.util.Scanner;

public class CalculaAreaRetangulo {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita a base do retângulo
        System.out.print("Digite a base do retângulo: ");
        double base = scanner.nextDouble();

        // Solicita a altura do retângulo
        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();

        // Calcula a área do retângulo
        double area = base * altura;

        // Exibe o resultado
        System.out.println("A área do retângulo é: " + area);

        // Fecha o Scanner
        scanner.close();
    }
}