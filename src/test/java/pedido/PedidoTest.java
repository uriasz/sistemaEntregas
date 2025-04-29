package pedido;

import cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Pedido pedido;
    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        cliente1 = new Cliente("João");
        cliente2 = new Cliente("Maria");
    }

    @Test
    public void testAdicionarObservador() {
        pedido.adicionarObservador(cliente1);
        pedido.adicionarObservador(cliente2);
        assertEquals(2, pedido.getObservadores().size());
    }

    @Test
    public void testRemoverObservador() {
        pedido.adicionarObservador(cliente1);
        pedido.removerObservador(cliente1);
        assertEquals(0, pedido.getObservadores().size());
    }

    @Test
    public void testSetEstadoComEstadoNulo() {
        List<String> mensagens = pedido.setEstado(null);
        assertEquals(1, mensagens.size());
        assertEquals("Erro: O estado do pedido não pode ser nulo.", mensagens.get(0));
    }

    @Test
    public void testSetEstadoComNotificacao() {
        pedido.adicionarObservador(cliente1);
        List<String> mensagens = pedido.setEstado(PedidoEstadoCriado.getInstancia());
        assertEquals(1, mensagens.size());
        assertEquals("Notificação para João: Estado do pedido alterado para: Criado", mensagens.get(0));
    }
}