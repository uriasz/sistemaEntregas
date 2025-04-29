package factory;

import teste.Pedido;
import cliente.Cliente;

public class PedidoFactory {

    public static Pedido criarPedido(Cliente cliente) {
        return new Pedido(cliente);
    }
}
