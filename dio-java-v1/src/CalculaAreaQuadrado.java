import java.util.Scanner;

public class CalculaAreaQuadrado {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita o tamanho do lado do quadrado
        System.out.print("Digite o tamanho do lado do quadrado: ");
        double lado = scanner.nextDouble();

        // Calcula a área do quadrado
        double area = lado * lado;

        // Exibe o resultado
        System.out.println("A área do quadrado é: " + area);

        // Fecha o Scanner
        scanner.close();
    }
}