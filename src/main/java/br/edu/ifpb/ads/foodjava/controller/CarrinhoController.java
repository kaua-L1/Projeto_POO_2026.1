package br.edu.ifpb.ads.foodjava.controller;
import br.edu.ifpb.ads.foodjava.model.*;
import br.edu.ifpb.ads.foodjava.repository.*;
import br.edu.ifpb.ads.foodjava.util.Sessao;

public class CarrinhoController {
	private ListaPedidosRepository repository = new ListaPedidosRepository();
	
	public void mostrarPedidos() {
		Pedido pedido = Sessao.getPedidoAtual();

		System.out.println(pedido.toStringCliente());
	}
	
	public void removerPedido(int numero) {

	    Pedido pedido = Sessao.getPedidoAtual();

	    pedido.removerPrato(numero - 1);
	}
	
	public void finalizarPedido() {
	    repository.adicionar(Sessao.getPedidoAtual());
	    Sessao.novoPedido();
	}
}
