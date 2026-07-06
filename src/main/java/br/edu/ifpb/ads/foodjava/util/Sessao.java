package br.edu.ifpb.ads.foodjava.util;
import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.model.Pedido;

public class Sessao {
    private static Cliente clienteLogado;
    private static Pedido pedidoAtual;

    public static Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public static void novoPedido() {
        pedidoAtual = new Pedido();
        pedidoAtual.setidCliente(clienteLogado.getId());
    }
    
    public static void setPedidoAtual(Pedido pedido) {
    	pedidoAtual = pedido;
    }

    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void logout() {
        clienteLogado = null;
    }
}