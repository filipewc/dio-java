import java.util.Scanner;

public class DivisaoResto {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o número inicial
        System.out.print("Digite o número inicial: ");
        int numeroInicial = scanner.nextInt();

        // Valida se o número inicial é maior que zero
        if (numeroInicial <= 0) {
            System.out.println("Erro: O número inicial deve ser maior que zero.");
            return; // Encerra o programa
        }

        System.out.println("Agora digite outros números. A execução continuará até que um número válido tenha resto diferente de zero na divisão pelo número inicial.");

        // Loop para receber os próximos números
        while (true) {
            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();

            // Ignora números menores que o número inicial
            if (numero < numeroInicial) {
                System.out.println("Número menor que o número inicial. Ignorado.");
                continue;
            }

            // Verifica o resto da divisão
            if (numero % numeroInicial != 0) {
                System.out.println("O número " + numero + " tem resto diferente de zero na divisão por " + numeroInicial + ".");
                break; // Encerra o loop
            } else {
                System.out.println("O número " + numero + " tem resto zero na divisão por " + numeroInicial + ". Continuando...");
            }
        }

        // Fecha o Scanner
        scanner.close();
    }
}