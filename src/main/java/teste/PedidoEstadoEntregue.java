package teste;

public class PedidoEstadoEntregue implements PedidoEstado {
    private static PedidoEstadoEntregue instancia;

    private PedidoEstadoEntregue() {}

    public static PedidoEstadoEntregue getInstance() {
        if (instancia == null) {
            instancia = new PedidoEstadoEntregue();
        }
        return instancia;
    }

    @Override
    public String getNomeEstado() {
        return "Entregue";
    }
}
