package br.edu.ifpb.ads.foodjava.controller;
import java.util.List;
import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.repository.ListaPedidosRepository;

public class HistoricoClienteController {
	private ListaPedidosRepository repository = new ListaPedidosRepository();
	
	public String mostrarHistorico(int id) {

	    List<Pedido> pedidos = repository.buscarPorCliente(id);

	    String texto = "";
	    System.out.println("Cliente logado: " + id);

	    for (Pedido pedido : pedidos) {
	        System.out.println(
	            "Pedido -> idCliente: " + pedido.getIdCliente()
	            + " | Status: " + pedido.getStatus());
	    }
	    for (Pedido pedido : pedidos) {
	    	
	        if (pedido.getIdCliente() == id &&
	            !pedido.getStatus().equals("CANCELADO_CLIENTE")) {

	            texto += pedido.toString();
	            texto += "\nStatus: " + pedido.getStatus();
	            texto += "\n------------------------\n";
	        }
	    }
	    return texto;
	}
}
