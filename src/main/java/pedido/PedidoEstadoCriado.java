package pedido;

public class PedidoEstadoCriado implements PedidoEstado {
    private static PedidoEstadoCriado instancia;

    private PedidoEstadoCriado() {}

    public static PedidoEstadoCriado getInstance() {
        if (instancia == null) {
            instancia = new PedidoEstadoCriado();
        }
        return instancia;
    }

    @Override
    public String getNomeEstado() {
        return "Criado";
    }
}
