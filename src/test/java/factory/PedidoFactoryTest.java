package factory;

import org.junit.jupiter.api.Test;
import pedido.Pedido;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoFactoryTest {

    @Test
    public void testCriarPedido() {
        Pedido pedido = PedidoFactory.criarPedido();
        assertNotNull(pedido);
        assertEquals("Criado", pedido.getEstado().getNomeEstado());
    }
}