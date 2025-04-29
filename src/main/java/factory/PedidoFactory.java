package factory;

import pedido.Pedido;

public class PedidoFactory {
    public static Pedido criarPedido() {
        return new Pedido();
    }
}