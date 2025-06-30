// Classe base Ingresso
class Ingresso {
    protected double valor;
    protected String nomeFilme;
    protected boolean dublado;

    // Construtor
    public Ingresso(double valor, String nomeFilme, boolean dublado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    // Método para retornar o valor real do ingresso (base)
    public double getValorReal() {
        return valor;
    }

    // Método para exibir informações do ingresso
    public void exibirInformacoes() {
        System.out.println("Filme: " + nomeFilme);
        System.out.println("Dublado: " + (dublado ? "Sim" : "Não"));
        System.out.println("Valor: R$" + getValorReal());
    }
}

// Subclasse MeiaEntrada
class MeiaEntrada extends Ingresso {

    // Construtor
    public MeiaEntrada(double valor, String nomeFilme, boolean dublado) {
        super(valor, nomeFilme, dublado);
    }

    // Sobrescreve o método para calcular o valor real (metade do valor)
    @Override
    public double getValorReal() {
        return valor / 2;
    }
}

// Subclasse IngressoFamilia
class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    // Construtor
    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    // Sobrescreve o método para calcular o valor real (com desconto para famílias grandes)
    @Override
    public double getValorReal() {
        double valorTotal = valor * numeroPessoas;
        if (numeroPessoas > 3) {
            valorTotal *= 0.95; // Aplica 5% de desconto
        }
        return valorTotal;
    }

    // Sobrescreve o método para exibir informações adicionais sobre o número de pessoas
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Número de pessoas: " + numeroPessoas);
    }
}

// Classe principal para testar a hierarquia de classes
public class Cinema {
    public static void main(String[] args) {
        // Criando um ingresso normal
        Ingresso ingressoNormal = new Ingresso(50.0, "Vingadores", true);
        System.out.println("=== Ingresso Normal ===");
        ingressoNormal.exibirInformacoes();

        // Criando um ingresso de meia entrada
        MeiaEntrada meiaEntrada = new MeiaEntrada(50.0, "Vingadores", true);
        System.out.println("\n=== Meia Entrada ===");
        meiaEntrada.exibirInformacoes();

        // Criando um ingresso família
        IngressoFamilia ingressoFamilia = new IngressoFamilia(50.0, "Vingadores", true, 4);
        System.out.println("\n=== Ingresso Família ===");
        ingressoFamilia.exibirInformacoes();
    }
}