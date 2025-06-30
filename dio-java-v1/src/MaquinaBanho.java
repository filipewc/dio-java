import java.util.Scanner;

public class MaquinaBanho {
    private int nivelAgua;
    private int nivelShampoo;
    private boolean temPetNoBanho;
    private boolean petLimpo;

    // Construtor da classe
    public MaquinaBanho() {
        this.nivelAgua = 0;         // Nível inicial de água
        this.nivelShampoo = 0;      // Nível inicial de shampoo
        this.temPetNoBanho = false; // Inicialmente não há pet na máquina
        this.petLimpo = false;      // Pet começa sujo
    }

    // Método para abastecer com água
    public void abastecerAgua() {
        if (nivelAgua + 2 <= 30) {
            nivelAgua += 2;
            System.out.println("Água abastecida. Nível atual: " + nivelAgua + " litros.");
        } else {
            System.out.println("Capacidade máxima de água atingida.");
        }
    }

    // Método para abastecer com shampoo
    public void abastecerShampoo() {
        if (nivelShampoo + 2 <= 10) {
            nivelShampoo += 2;
            System.out.println("Shampoo abastecido. Nível atual: " + nivelShampoo + " litros.");
        } else {
            System.out.println("Capacidade máxima de shampoo atingida.");
        }
    }

    // Método para verificar nível de água
    public void verificarNivelAgua() {
        System.out.println("Nível de água: " + nivelAgua + " litros.");
    }

    // Método para verificar nível de shampoo
    public void verificarNivelShampoo() {
        System.out.println("Nível de shampoo: " + nivelShampoo + " litros.");
    }

    // Método para colocar pet na máquina
    public void colocarPet() {
        if (!temPetNoBanho) {
            temPetNoBanho = true;
            petLimpo = false;
            System.out.println("Pet colocado na máquina.");
        } else {
            System.out.println("Já há um pet na máquina.");
        }
    }

    // Método para retirar pet da máquina
    public void retirarPet() {
        if (temPetNoBanho) {
            if (petLimpo) {
                System.out.println("Pet limpo retirado da máquina.");
            } else {
                System.out.println("Pet retirado sem estar limpo. É necessário limpar a máquina antes de colocar outro pet.");
            }
            temPetNoBanho = false;
            petLimpo = false;
        } else {
            System.out.println("Não há pet na máquina para ser retirado.");
        }
    }

    // Método para dar banho no pet
    public void darBanho() {
        if (temPetNoBanho) {
            if (nivelAgua >= 10 && nivelShampoo >= 2) {
                nivelAgua -= 10;
                nivelShampoo -= 2;
                petLimpo = true;
                System.out.println("Banho realizado com sucesso.");
            } else {
                System.out.println("Não há água ou shampoo suficiente para dar banho.");
            }
        } else {
            System.out.println("Não há pet na máquina para dar banho.");
        }
    }

    // Método para limpar a máquina
    public void limparMaquina() {
        if (nivelAgua >= 3 && nivelShampoo >= 1) {
            nivelAgua -= 3;
            nivelShampoo -= 1;
            System.out.println("Máquina limpa.");
        } else {
            System.out.println("Não há água ou shampoo suficiente para limpar a máquina.");
        }
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaBanho maquina = new MaquinaBanho();

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Abastecer com água");
            System.out.println("2 - Abastecer com shampoo");
            System.out.println("3 - Verificar nível de água");
            System.out.println("4 - Verificar nível de shampoo");
            System.out.println("5 - Colocar pet na máquina");
            System.out.println("6 - Retirar pet da máquina");
            System.out.println("7 - Dar banho no pet");
            System.out.println("8 - Limpar máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    maquina.abastecerAgua();
                    break;
                case 2:
                    maquina.abastecerShampoo();
                    break;
                case 3:
                    maquina.verificarNivelAgua();
                    break;
                case 4:
                    maquina.verificarNivelShampoo();
                    break;
                case 5:
                    maquina.colocarPet();
                    break;
                case 6:
                    maquina.retirarPet();
                    break;
                case 7:
                    maquina.darBanho();
                    break;
                case 8:
                    maquina.limparMaquina();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}