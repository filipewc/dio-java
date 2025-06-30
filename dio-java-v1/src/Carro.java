import java.util.Scanner;

public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    // Construtor da classe
    public Carro() {
        this.ligado = false; // Carro começa desligado
        this.velocidade = 0; // Velocidade inicial é 0
        this.marcha = 0;     // Marcha inicial é ponto morto (0)
    }

    // Método para ligar o carro
    public void ligarCarro() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    // Método para desligar o carro
    public void desligarCarro() {
        if (ligado && marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else if (!ligado) {
            System.out.println("O carro já está desligado.");
        } else {
            System.out.println("Não é possível desligar o carro. Certifique-se de que ele está em ponto morto e com velocidade 0.");
        }
    }

    // Método para acelerar o carro
    public void acelerar() {
        if (ligado) {
            if (marcha == 0) {
                System.out.println("Não é possível acelerar no ponto morto.");
            } else if (velocidade < getVelocidadeMaximaPorMarcha(marcha)) {
                velocidade++;
                System.out.println("Acelerando. Velocidade atual: " + velocidade + " km/h");
            } else {
                System.out.println("Velocidade máxima para esta marcha atingida.");
            }
        } else {
            System.out.println("O carro está desligado. Não é possível acelerar.");
        }
    }

    // Método para diminuir a velocidade do carro
    public void diminuirVelocidade() {
        if (ligado) {
            if (velocidade > 0) {
                velocidade--;
                System.out.println("Diminuindo velocidade. Velocidade atual: " + velocidade + " km/h");
            } else {
                System.out.println("O carro já está parado.");
            }
        } else {
            System.out.println("O carro está desligado. Não é possível diminuir a velocidade.");
        }
    }

    // Método para trocar a marcha
    public void trocarMarcha(int novaMarcha) {
        if (ligado) {
            if (novaMarcha >= 0 && novaMarcha <= 6) {
                if (novaMarcha == marcha + 1 || novaMarcha == marcha - 1) {
                    if (novaMarcha == 0 || (velocidade >= getVelocidadeMinimaPorMarcha(novaMarcha) && velocidade <= getVelocidadeMaximaPorMarcha(novaMarcha))) {
                        marcha = novaMarcha;
                        System.out.println("Marcha alterada para " + marcha);
                    } else {
                        System.out.println("Velocidade não compatível com a marcha selecionada.");
                    }
                } else {
                    System.out.println("Não é permitido pular marchas. Altere para a marcha adjacente.");
                }
            } else {
                System.out.println("Marcha inválida. Escolha uma marcha entre 0 e 6.");
            }
        } else {
            System.out.println("O carro está desligado. Não é possível trocar a marcha.");
        }
    }

    // Método para virar para a esquerda ou direita
    public void virar(String direcao) {
        if (ligado) {
            if (velocidade >= 1 && velocidade <= 40) {
                System.out.println("Virando para " + direcao + ".");
            } else {
                System.out.println("Não é possível virar. Velocidade deve estar entre 1 km/h e 40 km/h.");
            }
        } else {
            System.out.println("O carro está desligado. Não é possível virar.");
        }
    }

    // Método para verificar a velocidade atual
    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }

    // Método auxiliar para obter a velocidade mínima por marcha
    private int getVelocidadeMinimaPorMarcha(int marcha) {
        switch (marcha) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 41;
            case 4:
                return 61;
            case 5:
                return 81;
            case 6:
                return 101;
            default:
                return 0; // Ponto morto
        }
    }

    // Método auxiliar para obter a velocidade máxima por marcha
    private int getVelocidadeMaximaPorMarcha(int marcha) {
        switch (marcha) {
            case 1:
                return 20;
            case 2:
                return 40;
            case 3:
                return 60;
            case 4:
                return 80;
            case 5:
                return 100;
            case 6:
                return 120;
            default:
                return 0; // Ponto morto
        }
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar para esquerda/direita");
            System.out.println("7 - Verificar velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligarCarro();
                    break;
                case 2:
                    carro.desligarCarro();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.diminuirVelocidade();
                    break;
                case 5:
                    System.out.print("Digite a nova marcha (0-6): ");
                    int novaMarcha = scanner.nextInt();
                    carro.trocarMarcha(novaMarcha);
                    break;
                case 6:
                    System.out.print("Digite 'esquerda' ou 'direita': ");
                    String direcao = scanner.next();
                    carro.virar(direcao);
                    break;
                case 7:
                    carro.verificarVelocidade();
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