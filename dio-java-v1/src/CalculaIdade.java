import java.util.Scanner;

public class CalculaIdade {
    public static void main(String[] args) {
        // Cria um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Solicita o ano de nascimento do usuário
        System.out.print("Digite o ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        // Obtém o ano atual
        int anoAtual = java.time.Year.now().getValue();

        // Calcula a idade
        int idade = anoAtual - anoNascimento;

        // Imprime a mensagem formatada
        System.out.println("Olá " + nome + ", você tem " + idade + " anos.");

        // Fecha o Scanner
        scanner.close();
    }
}