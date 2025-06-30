import java.util.Scanner;

// Classe ContaBancaria (Exercício 1)
class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        if (saldoInicial <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = saldoInicial * 0.5;
        }
        this.chequeEspecialUsado = 0;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void consultarChequeEspecial() {
        System.out.println("Limite de cheque especial: R$" + chequeEspecial);
        System.out.println("Cheque especial usado: R$" + chequeEspecialUsado);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * 0.2;
            saldo -= taxa;
            System.out.println("Taxa de 20% sobre o cheque especial usado: R$" + taxa);
            chequeEspecialUsado = 0;
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else if (valor <= saldo + chequeEspecial - chequeEspecialUsado) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialUsado += restante;
            System.out.println("Saque de R$" + valor + " realizado com sucesso usando cheque especial.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor);
        System.out.println("Boleto no valor de R$" + valor + " pago com sucesso.");
    }

    public boolean estaUsandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }
}

// Nova Classe Carro (Exercício 2)
class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public void ligarCarro() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

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

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }

    private int getVelocidadeMinimaPorMarcha(int marcha) {
        switch (marcha) {
            case 1: return 0;
            case 2: return 21;
            case 3: return 41;
            case 4: return 61;
            case 5: return 81;
            case 6: return 101;
            default: return 0;
        }
    }

    private int getVelocidadeMaximaPorMarcha(int marcha) {
        switch (marcha) {
            case 1: return 20;
            case 2: return 40;
            case 3: return 60;
            case 4: return 80;
            case 5: return 100;
            case 6: return 120;
            default: return 0;
        }
    }
}

// Classe MaquinaBanho (Exercício 3)
class MaquinaBanho {
    private int nivelAgua;
    private int nivelShampoo;
    private boolean petNoBanho;
    private boolean petLimpo;

    public MaquinaBanho() {
        this.nivelAgua = 0;
        this.nivelShampoo = 0;
        this.petNoBanho = false;
        this.petLimpo = false;
    }

    public void abastecerAgua() {
        if (nivelAgua + 2 <= 30) {
            nivelAgua += 2;
            System.out.println("Água abastecida. Nível atual: " + nivelAgua + " litros.");
        } else {
            System.out.println("Capacidade máxima de água atingida.");
        }
    }

    public void abastecerShampoo() {
        if (nivelShampoo + 2 <= 10) {
            nivelShampoo += 2;
            System.out.println("Shampoo abastecido. Nível atual: " + nivelShampoo + " litros.");
        } else {
            System.out.println("Capacidade máxima de shampoo atingida.");
        }
    }

    public void verificarNivelAgua() {
        System.out.println("Nível de água: " + nivelAgua + " litros.");
    }

    public void verificarNivelShampoo() {
        System.out.println("Nível de shampoo: " + nivelShampoo + " litros.");
    }

    public void colocarPet() {
        if (!petNoBanho) {
            petNoBanho = true;
            petLimpo = false;
            System.out.println("Pet colocado na máquina.");
        } else {
            System.out.println("Já há um pet na máquina.");
        }
    }

    public void retirarPet() {
        if (petNoBanho) {
            if (petLimpo) {
                petNoBanho = false;
                System.out.println("Pet retirado da máquina.");
            } else {
                System.out.println("O pet não está limpo. Limpe a máquina antes de retirar o pet.");
            }
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }

    public void darBanho() {
        if (petNoBanho) {
            if (nivelAgua >= 10 && nivelShampoo >= 2) {
                nivelAgua -= 10;
                nivelShampoo -= 2;
                petLimpo = true;
                System.out.println("Banho realizado com sucesso.");
            } else {
                System.out.println("Níveis insuficientes de água ou shampoo para dar banho.");
            }
        } else {
            System.out.println("Não há pet na máquina para dar banho.");
        }
    }

    public void limparMaquina() {
        if (nivelAgua >= 3 && nivelShampoo >= 1) {
            nivelAgua -= 3;
            nivelShampoo -= 1;
            petLimpo = false;
            System.out.println("Máquina limpa.");
        } else {
            System.out.println("Níveis insuficientes de água ou shampoo para limpar a máquina.");
        }
    }

    public void verificarPetNoBanho() {
        if (petNoBanho) {
            System.out.println("Há um pet na máquina.");
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }
}

// Classe Principal com Menu Interativo
public class MenuInterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Conta Bancária");
            System.out.println("2 - Carro");
            System.out.println("3 - Máquina de Banho");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    menuContaBancaria(scanner);
                    break;
                case 2:
                    menuCarro(scanner);
                    break;
                case 3:
                    menuMaquinaBanho(scanner);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaBancaria(Scanner scanner) {
        System.out.print("Informe o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(saldoInicial);

        while (true) {
            System.out.println("\n=== Menu Conta Bancária ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso de cheque especial");
            System.out.println("7 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Informe o valor a depositar: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 4:
                    System.out.print("Informe o valor a sacar: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 5:
                    System.out.print("Informe o valor do boleto: ");
                    double boleto = scanner.nextDouble();
                    conta.pagarBoleto(boleto);
                    break;
                case 6:
                    if (conta.estaUsandoChequeEspecial()) {
                        System.out.println("A conta está usando cheque especial.");
                    } else {
                        System.out.println("A conta não está usando cheque especial.");
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuCarro(Scanner scanner) {
        Carro carro = new Carro();

        while (true) {
            System.out.println("\n=== Menu Carro ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar para esquerda/direita");
            System.out.println("7 - Verificar velocidade");
            System.out.println("8 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

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
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuMaquinaBanho(Scanner scanner) {
        MaquinaBanho maquina = new MaquinaBanho();

        while (true) {
            System.out.println("\n=== Menu Máquina de Banho ===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer com água");
            System.out.println("3 - Abastecer com shampoo");
            System.out.println("4 - Verificar nível de água");
            System.out.println("5 - Verificar nível de shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("10 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    maquina.darBanho();
                    break;
                case 2:
                    maquina.abastecerAgua();
                    break;
                case 3:
                    maquina.abastecerShampoo();
                    break;
                case 4:
                    maquina.verificarNivelAgua();
                    break;
                case 5:
                    maquina.verificarNivelShampoo();
                    break;
                case 6:
                    maquina.verificarPetNoBanho();
                    break;
                case 7:
                    maquina.colocarPet();
                    break;
                case 8:
                    maquina.retirarPet();
                    break;
                case 9:
                    maquina.limparMaquina();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}