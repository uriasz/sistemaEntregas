package cliente;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String notificar(String mensagem) {
        return "Notificação para " + nome + ": " + mensagem;
    }
}