package pedido;

public class PedidoEstadoEmRota implements PedidoEstado {
    private static final PedidoEstadoEmRota INSTANCIA = new PedidoEstadoEmRota();

    private PedidoEstadoEmRota() {}

    public static PedidoEstadoEmRota getInstancia() {
        return INSTANCIA;
    }

    @Override
    public String getNomeEstado() {
        return "Em Rota de Entrega";
    }
}
