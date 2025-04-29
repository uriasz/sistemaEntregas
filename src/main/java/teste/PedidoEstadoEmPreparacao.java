package teste;

public class PedidoEstadoEmPreparacao implements PedidoEstado {
    private static PedidoEstadoEmPreparacao instancia;

    private PedidoEstadoEmPreparacao() {}

    public static PedidoEstadoEmPreparacao getInstance() {
        if (instancia == null) {
            instancia = new PedidoEstadoEmPreparacao();
        }
        return instancia;
    }

    @Override
    public String getNomeEstado() {
        return "Em Preparação";
    }
}
