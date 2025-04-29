package pedido;

public class PedidoEstadoEntregue implements PedidoEstado {
    private static final PedidoEstadoEntregue INSTANCIA = new PedidoEstadoEntregue();

    private PedidoEstadoEntregue() {}

    public static PedidoEstadoEntregue getInstancia() {
        return INSTANCIA;
    }

    @Override
    public String getNomeEstado() {
        return "Entregue";
    }
}
