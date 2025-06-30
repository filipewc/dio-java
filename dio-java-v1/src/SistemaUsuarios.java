// Classe base Usuário
class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean isAdmin;

    // Construtor
    public Usuario(String nome, String email, String senha, boolean isAdmin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    // Métodos comuns a todos os usuários
    public void realizarLogin(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Login realizado com sucesso para " + nome);
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    public void realizarLogoff() {
        System.out.println("Logoff realizado para " + nome);
    }

    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados alterados com sucesso.");
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

// Classe Gerente
class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true); // isAdmin sempre verdadeiro
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro gerado por " + nome);
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas realizadas...");
    }
}

// Classe Vendedor
class Vendedor extends Usuario {
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false); // isAdmin sempre falso
        this.quantidadeVendas = 0;
    }

    public void realizarVenda() {
        quantidadeVendas++;
        System.out.println("Venda realizada. Total de vendas: " + quantidadeVendas);
    }

    public void consultarVendas() {
        System.out.println("Total de vendas realizadas por " + nome + ": " + quantidadeVendas);
    }

    // Getter para quantidade de vendas
    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }
}

// Classe Atendente
class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false); // isAdmin sempre falso
        this.valorEmCaixa = 0.0;
    }

    public void receberPagamento(double valor) {
        valorEmCaixa += valor;
        System.out.println("Pagamento recebido. Valor em caixa: R$" + valorEmCaixa);
    }

    public void fecharCaixa() {
        System.out.println("Caixa fechado. Valor total no caixa: R$" + valorEmCaixa);
        valorEmCaixa = 0.0; // Zera o valor do caixa após fechá-lo
    }

    // Getter para valor em caixa
    public double getValorEmCaixa() {
        return valorEmCaixa;
    }
}

// Classe principal para testar as funcionalidades
public class SistemaUsuarios {
    public static void main(String[] args) {
        // Criando um gerente
        Gerente gerente = new Gerente("João", "joao@email.com", "senha123");
        gerente.realizarLogin("joao@email.com", "senha123");
        gerente.gerarRelatorioFinanceiro();
        gerente.consultarVendas();
        gerente.alterarSenha("novaSenha456");
        gerente.realizarLogoff();

        System.out.println();

        // Criando um vendedor
        Vendedor vendedor = new Vendedor("Maria", "maria@email.com", "vendedor123");
        vendedor.realizarLogin("maria@email.com", "vendedor123");
        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.consultarVendas();
        vendedor.alterarDados("Maria Silva", "maria.silva@email.com");
        vendedor.realizarLogoff();

        System.out.println();

        // Criando um atendente
        Atendente atendente = new Atendente("Pedro", "pedro@email.com", "atendente123");
        atendente.realizarLogin("pedro@email.com", "atendente123");
        atendente.receberPagamento(50.0);
        atendente.receberPagamento(75.5);
        atendente.fecharCaixa();
        atendente.alterarSenha("novaSenha789");
        atendente.realizarLogoff();
    }
}