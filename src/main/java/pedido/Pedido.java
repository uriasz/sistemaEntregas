package pedido;

import cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private PedidoEstado estado;
    private List<Cliente> observadores;

    public Pedido() {
        this.estado = PedidoEstadoCriado.getInstancia();
        this.observadores = new ArrayList<>();
    }

    public void adicionarObservador(Cliente cliente) {
        observadores.add(cliente);
    }

    public void removerObservador(Cliente cliente) {
        observadores.remove(cliente);
    }

    public List<Cliente> getObservadores() {
        return observadores;
    }

    public List<String> setEstado(PedidoEstado novoEstado) {
        if (novoEstado == null) {
            List<String> mensagensErro = new ArrayList<>();
            mensagensErro.add("Erro: O estado do pedido não pode ser nulo.");
            return mensagensErro;
        }

        this.estado = novoEstado;
        return notificarObservadores();
    }

    public PedidoEstado getEstado() {
        return this.estado;
    }

    private List<String> notificarObservadores() {
        List<String> mensagens = new ArrayList<>();
        for (Cliente cliente : observadores) {
            mensagens.add(cliente.notificar("Estado do pedido alterado para: " + estado.getNomeEstado()));
        }
        return mensagens;
    }
}
