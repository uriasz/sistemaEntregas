package cliente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testNotificar() {
        Cliente cliente = new Cliente("João");
        String mensagem = cliente.notificar("Seu pedido foi enviado.");

        assertEquals("Notificação para João: Seu pedido foi enviado.", mensagem);
    }
}
