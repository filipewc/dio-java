import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Verifica se a próxima entrada é um número do tipo double
        if (scanner.hasNextDouble()) {
            // Lê o valor em Celsius fornecido pelo usuário
            double celsius = scanner.nextDouble();

            // Verifica se a temperatura fornecida é maior ou igual ao zero absoluto (-273.15°C)
            if (celsius >= -273.15) {
                // Converte a temperatura de Celsius para Fahrenheit
                double fahrenheit = (celsius * 9 / 5) + 32;

                // Exibe o resultado formatado com uma casa decimal
                System.out.printf("%.1f%n", fahrenheit);
            } else {
                // Caso a temperatura seja menor que -273.15, exibe mensagem de erro
                System.out.println("Entrada invalida");
            }
        } else {
            // Caso a entrada não seja um número válido, exibe mensagem de erro
            System.out.println("Entrada invalida");
        }

        scanner.close();
    }
}