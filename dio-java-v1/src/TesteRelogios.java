// Classe pai Relogio
abstract class Relogio {
    protected int hora;
    protected int minuto;
    protected int segundo;

    // Construtor
    public Relogio(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    // Getters e Setters com validações
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida. Deve estar entre 0 e 23.");
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido. Deve estar entre 0 e 59.");
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException("Segundo inválido. Deve estar entre 0 e 59.");
        }
        this.segundo = segundo;
    }

    // Método para retornar a hora no formato HH:MM:SS
    public String getHoraFormatada() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void sincronizarCom(Relogio outroRelogio);

    // Método auxiliar para ajustar a hora com base em outro relógio
    protected void ajustarHora(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }
}

// Subclasse RelogioAmericano
class RelogioAmericano extends Relogio {

    // Construtor
    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
        validarHoraAmericana();
    }

    // Validação específica para o relógio americano
    private void validarHoraAmericana() {
        if (hora > 12) {
            hora %= 12; // Converte para o formato de 12 horas
        }
    }

    // Implementação do método abstrato
    @Override
    public void sincronizarCom(Relogio outroRelogio) {
        int novaHora = outroRelogio.getHora();
        if (novaHora > 12) {
            novaHora %= 12; // Converte para o formato de 12 horas
        }
        ajustarHora(novaHora, outroRelogio.getMinuto(), outroRelogio.getSegundo());
        System.out.println("Relógio Americano sincronizado com sucesso.");
    }
}

// Subclasse RelogioBrasileiro
class RelogioBrasileiro extends Relogio {

    // Construtor
    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    // Implementação do método abstrato
    @Override
    public void sincronizarCom(Relogio outroRelogio) {
        ajustarHora(outroRelogio.getHora(), outroRelogio.getMinuto(), outroRelogio.getSegundo());
        System.out.println("Relógio Brasileiro sincronizado com sucesso.");
    }
}

// Classe principal para testar as funcionalidades
public class TesteRelogios {
    public static void main(String[] args) {
        // Criando um relógio brasileiro
        RelogioBrasileiro relogioBr = new RelogioBrasileiro(14, 30, 45);
        System.out.println("Relógio Brasileiro: " + relogioBr.getHoraFormatada());

        // Criando um relógio americano
        RelogioAmericano relogioAm = new RelogioAmericano(18, 45, 10);
        System.out.println("Relógio Americano: " + relogioAm.getHoraFormatada());

        // Sincronizando o relógio americano com o brasileiro
        relogioAm.sincronizarCom(relogioBr);
        System.out.println("Relógio Americano após sincronização: " + relogioAm.getHoraFormatada());

        // Sincronizando o relógio brasileiro com o americano
        relogioBr.sincronizarCom(relogioAm);
        System.out.println("Relógio Brasileiro após sincronização: " + relogioBr.getHoraFormatada());
    }
}