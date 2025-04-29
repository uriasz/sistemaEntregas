package teste;

public class PedidoEstadoEmRota implements PedidoEstado {
    private static PedidoEstadoEmRota instancia;

    private PedidoEstadoEmRota() {}

    public static PedidoEstadoEmRota getInstance() {
        if (instancia == null) {
            instancia = new PedidoEstadoEmRota();
        }
        return instancia;
    }

    @Override
    public String getNomeEstado() {
        return "Em Rota de Entrega";
    }
}
