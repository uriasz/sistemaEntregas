package observer;

import teste.Pedido;

public interface Observer {
    void update(Pedido pedido, String mensagem);
}
