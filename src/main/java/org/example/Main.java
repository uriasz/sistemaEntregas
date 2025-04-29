import cliente.Cliente;
import factory.PedidoFactory;
import pedido.Pedido;
import pedido.PedidoEstadoCriado; // <--- aqui!
import pedido.PedidoEstadoEmPreparacao;
import pedido.PedidoEstadoEmRota;
import pedido.PedidoEstadoEntregue;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = PedidoFactory.criarPedido();

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        pedido.adicionarObservador(cliente1);
        pedido.adicionarObservador(cliente2);

        // Corrigido aqui!
        List<String> mensagensInicial = pedido.setEstado(PedidoEstadoCriado.getInstancia());
        mensagensInicial.forEach(System.out::println);

        List<String> mensagensPreparacao = pedido.setEstado(PedidoEstadoEmPreparacao.getInstancia());
        mensagensPreparacao.forEach(System.out::println);

        List<String> mensagensRota = pedido.setEstado(PedidoEstadoEmRota.getInstancia());
        mensagensRota.forEach(System.out::println);

        List<String> mensagensEntregue = pedido.setEstado(PedidoEstadoEntregue.getInstancia());
        mensagensEntregue.forEach(System.out::println);
    }
}
