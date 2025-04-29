package teste;


import cliente.Cliente;
import java.util.UUID;

public class Pedido {
    private String id;
    private PedidoEstado estado;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString(); // gera um ID único
        this.estado = PedidoEstadoCriado.getInstance(); // começa com estado Criado
        this.cliente = cliente;
        cliente.adicionarPedido(this); // associa o pedido ao cliente
    }

    public String getId() {
        return id;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEstado(PedidoEstado novoEstado) {
        if (novoEstado == null) {
            return;
        }
        this.estado = novoEstado;
        notifyObserver();
    }

    public void notifyObserver() {
        if (cliente != null) {
            String mensagem = "Pedido " + getId() + " mudou para o estado: " + estado.getNomeEstado();
            cliente.update(this, mensagem);
        }
    }
}
