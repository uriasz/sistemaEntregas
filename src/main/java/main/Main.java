package main;

import factory.PedidoFactory;
import teste.Pedido;
import teste.PedidoEstadoEmPreparacao;
import teste.PedidoEstadoEmRota;
import teste.PedidoEstadoEntregue;
import cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente ana = new Cliente("Ana");

        Pedido pedido1 = PedidoFactory.criarPedido(ana);
        Pedido pedido2 = PedidoFactory.criarPedido(ana);

        pedido1.setEstado(PedidoEstadoEmPreparacao.getInstance());
        pedido1.setEstado(PedidoEstadoEmRota.getInstance());
        pedido1.setEstado(PedidoEstadoEntregue.getInstance());

        pedido2.setEstado(PedidoEstadoEmPreparacao.getInstance());
    }
}
