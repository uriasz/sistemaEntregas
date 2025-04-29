package cliente;

import observer.Observer;
import teste.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observer {
    private String nome;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<String> notificacoes = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<String> getNotificacoes() {
        return notificacoes;
    }

    @Override
    public void update(Pedido pedido, String mensagem) {
        notificacoes.add(mensagem);
    }
}
