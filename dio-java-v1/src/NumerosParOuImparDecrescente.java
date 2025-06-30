import java.util.Scanner;

public class NumerosParOuImparDecrescente {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o primeiro número
        System.out.print("Digite o primeiro número: ");
        int numero1 = scanner.nextInt();

        // Solicita ao usuário o segundo número (deve ser maior que o primeiro)
        System.out.print("Digite o segundo número (maior que o primeiro): ");
        int numero2 = scanner.nextInt();

        // Valida se o segundo número é maior que o primeiro
        if (numero2 <= numero1) {
            System.out.println("Erro: O segundo número deve ser maior que o primeiro.");
            return; // Encerra o programa
        }

        // Solicita ao usuário a escolha entre "par" ou "ímpar"
        System.out.print("Escolha 'par' ou 'impar': ");
        String escolha = scanner.next().toLowerCase(); // Converte para minúsculas

        // Valida a escolha do usuário
        if (!escolha.equals("par") && !escolha.equals("impar")) {
            System.out.println("Erro: Escolha inválida. Digite 'par' ou 'impar'.");
            return; // Encerra o programa
        }

        // Exibe os números no intervalo em ordem decrescente
        System.out.println("Números " + escolha + " no intervalo de " + numero1 + " a " + numero2 + ":");
        for (int i = numero2; i >= numero1; i--) {
            if (escolha.equals("par") && i % 2 == 0) {
                System.out.println(i); // Imprime se for par
            } else if (escolha.equals("impar") && i % 2 != 0) {
                System.out.println(i); // Imprime se for ímpar
            }
        }

        // Fecha o Scanner
        scanner.close();
    }
}