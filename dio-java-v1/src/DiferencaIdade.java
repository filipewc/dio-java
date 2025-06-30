import java.util.Scanner;

public class DiferencaIdade {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita os dados da primeira pessoa
        System.out.print("Digite o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite a idade da primeira pessoa: ");
        int idade1 = scanner.nextInt();

        // Limpa o buffer do Scanner antes de ler o próximo nome
        scanner.nextLine();

        // Solicita os dados da segunda pessoa
        System.out.print("Digite o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite a idade da segunda pessoa: ");
        int idade2 = scanner.nextInt();

        // Calcula a diferença de idade (em valor absoluto)
        int diferencaIdade = Math.abs(idade1 - idade2);

        // Exibe o resultado
        System.out.println("A diferença de idade entre " + nome1 + " e " + nome2 + " é de " + diferencaIdade + " anos.");

        // Fecha o Scanner
        scanner.close();
    }
}