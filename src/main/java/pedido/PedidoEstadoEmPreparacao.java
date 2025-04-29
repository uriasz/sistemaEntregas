package pedido;

public class PedidoEstadoEmPreparacao implements PedidoEstado {
    private static final PedidoEstadoEmPreparacao INSTANCIA = new PedidoEstadoEmPreparacao();

    private PedidoEstadoEmPreparacao() {}

    public static PedidoEstadoEmPreparacao getInstancia() {
        return INSTANCIA;
    }

    @Override
    public String getNomeEstado() {
        return "Em Preparação";
    }
}
