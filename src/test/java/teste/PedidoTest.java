package teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cliente.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Cliente cliente;
    private Pedido pedido;

    @BeforeEach
    public void setup() {
        // Criar um cliente antes de cada teste
        cliente = new Cliente("Ana");
        pedido = new Pedido(cliente);
    }

    @Test
    public void testPedidoEstadoInicial() {
        // Verificar que o pedido começa com o estado "Criado"
        assertEquals("Criado", pedido.getEstado().getNomeEstado());
    }

    @Test
    public void testPedidoMudancaEstadoEmPreparacao() {
        // Mudar o estado para "Em Preparação"
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());

        // Verificar se o estado foi alterado corretamente
        assertEquals("Em Preparação", pedido.getEstado().getNomeEstado());
    }

    @Test
    public void testPedidoMudancaEstadoEmRota() {
        // Mudar o estado para "Em Rota"
        pedido.setEstado(PedidoEstadoEmRota.getInstance());

        // Verificar se o estado foi alterado corretamente
        assertEquals("Em Rota de Entrega", pedido.getEstado().getNomeEstado());
    }

    @Test
    public void testPedidoMudancaEstadoEntregue() {
        // Mudar o estado para "Entregue"
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        // Verificar se o estado foi alterado corretamente
        assertEquals("Entregue", pedido.getEstado().getNomeEstado());
    }

    @Test
    public void testNotificacaoClienteEstadoCriado() {
        // Testando a notificação de "Criado"
        pedido.setEstado(PedidoEstadoCriado.getInstance());

        // Verificar se a notificação foi armazenada
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido.getId() + " mudou para o estado: Criado"));
    }

    @Test
    public void testNotificacaoClienteEmPreparacao() {
        // Testando a notificação de "Em Preparação"
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());

        // Verificar se a notificação foi armazenada
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido.getId() + " mudou para o estado: Em Preparação"));
    }

    @Test
    public void testNotificacaoClienteEmRota() {
        // Testando a notificação de "Em Rota de Entrega"
        pedido.setEstado(PedidoEstadoEmRota.getInstance());

        // Verificar se a notificação foi armazenada
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido.getId() + " mudou para o estado: Em Rota de Entrega"));
    }

    @Test
    public void testNotificacaoClienteEntregue() {
        // Testando a notificação de "Entregue"
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        // Verificar se a notificação foi armazenada
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido.getId() + " mudou para o estado: Entregue"));
    }

    @Test
    public void testMultiplePedidos() {
        // Testando múltiplos pedidos para o mesmo cliente
        Pedido pedido1 = new Pedido(cliente);
        Pedido pedido2 = new Pedido(cliente);

        pedido1.setEstado(PedidoEstadoEmPreparacao.getInstance());
        pedido2.setEstado(PedidoEstadoEntregue.getInstance());

        // Verificar que o cliente recebeu as notificações de ambos os pedidos
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido1.getId() + " mudou para o estado: Em Preparação"));
        assertTrue(cliente.getNotificacoes().contains("Pedido " + pedido2.getId() + " mudou para o estado: Entregue"));
    }

    @Test
    public void testEstadoNull() {
        // Testar mudança de estado com valor nulo (não deve ocorrer alteração)
        Pedido pedido = new Pedido(cliente);
        pedido.setEstado(null);

        // Verificar que o estado não foi alterado
        assertEquals("Criado", pedido.getEstado().getNomeEstado());
    }
}
