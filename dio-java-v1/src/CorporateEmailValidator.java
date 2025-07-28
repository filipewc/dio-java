import java.util.Scanner;

public class CorporateEmailValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expectedDomain = "@company.com";
        String email = scanner.nextLine().trim();

        // Verifica se o e-mail contém o domínio esperado
        if (email.endsWith(expectedDomain)) {
            System.out.println("E-mail valido");
        } else {
            System.out.println("E-mail invalido");
        }

        scanner.close();
    }
}