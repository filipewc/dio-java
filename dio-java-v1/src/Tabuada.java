import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira um número
        System.out.print("Digite um número para gerar a tabuada: ");
        int numero = scanner.nextInt();

        // Exibe a tabuada de 1 até 10
        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        // Fecha o Scanner
        scanner.close();
    }
}