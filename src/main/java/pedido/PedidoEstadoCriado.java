package pedido;

public class PedidoEstadoCriado implements PedidoEstado {
    private static final PedidoEstadoCriado INSTANCIA = new PedidoEstadoCriado();

    private PedidoEstadoCriado() {}

    public static PedidoEstadoCriado getInstancia() {
        return INSTANCIA;
    }

    @Override
    public String getNomeEstado() {
        return "Criado";
    }
}
