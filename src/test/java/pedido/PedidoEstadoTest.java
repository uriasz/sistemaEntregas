package pedido;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoEstadoTest {

    @Test
    void testPedidoEstadoCriado() {
        PedidoEstado estado = PedidoEstadoCriado.getInstancia();
        assertEquals("Criado", estado.getNomeEstado());
    }

    @Test
    void testPedidoEstadoEmPreparacao() {
        PedidoEstado estado = PedidoEstadoEmPreparacao.getInstancia();
        assertEquals("Em Preparação", estado.getNomeEstado());
    }

    @Test
    void testPedidoEstadoEmRota() {
        PedidoEstado estado = PedidoEstadoEmRota.getInstancia();
        assertEquals("Em Rota de Entrega", estado.getNomeEstado());
    }

    @Test
    void testPedidoEstadoEntregue() {
        PedidoEstado estado = PedidoEstadoEntregue.getInstancia();
        assertEquals("Entregue", estado.getNomeEstado());
    }
}
