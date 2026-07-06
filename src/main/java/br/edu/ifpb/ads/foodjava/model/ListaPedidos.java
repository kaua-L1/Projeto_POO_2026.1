package br.edu.ifpb.ads.foodjava.model;
import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {

    private List<Pedido> pedidos = new ArrayList<>();
    
    public ListaPedidos() {
    	
    }
    
    public Pedido getPedido(int id) {
    	for(int i =0; i<pedidos.size();i++) {
    		if(pedidos.get(i).getID() == id) {
    			return pedidos.get(i);
    		}
    	}	return null;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
