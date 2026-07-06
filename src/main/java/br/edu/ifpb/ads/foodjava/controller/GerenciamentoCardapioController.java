package br.edu.ifpb.ads.foodjava.controller;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.ads.foodjava.model.*;
import br.edu.ifpb.ads.foodjava.repository.*;
import br.edu.ifpb.ads.foodjava.util.Sessao;

public class GerenciamentoCardapioController {
	CardapioRepository cardapioRepository = new CardapioRepository();
	ListaPedidosRepository listaPedidosRespository = new ListaPedidosRepository();
	
	public List<ItemCardapio> listarOrdenado() {

	    Cardapio cardapio = cardapioRepository.buscar();
	    List<ItemCardapio> resultado = new ArrayList<>();

	    String[] categorias = {
	        "ENTRADA",
	        "PRATO_PRINCIPAL",
	        "BEBIDAS",
	        "SOBREMESA"
	    };

	    for (String categoria : categorias) {
	        for (ItemCardapio item : cardapio.getCardapio()) {
	            if (item.getCategoria().equals(categoria)) {
	                resultado.add(item);
	            }
	        }
	    }

	    return resultado;
	}
	
	public String mostrarPorCategoria() {
		
		List<ItemCardapio> itens = listarOrdenado();
	    StringBuilder sb = new StringBuilder();
	    
	    String[] categorias = {
	        "ENTRADA",
	        "PRATO_PRINCIPAL",
	        "BEBIDAS",
	        "SOBREMESA"
	    };
	    
	    int numero = 1;
	    for (String categoria : categorias) {
	        sb.append("\n=== ").append(categoria).append(" ===\n");

	        for (ItemCardapio item : itens) {

	            if (item.getCategoria().equals(categoria)) {

	            	sb.append(numero)
	            	  .append(" - ")
	            	  .append(item.getNome())
	            	  .append(" - R$ ")
	            	  .append(item.getPreco())
	            	  .append("\n");

	            	numero++;
	            }
	        }
	    }
	    return sb.toString();
	}
	
	public ItemCardapio escolherItem(int numero) {
	    List<ItemCardapio> itens = listarOrdenado();
	    if (numero <= 0 || numero > itens.size()) {
	        return null;
	    }
	    return itens.get(numero - 1);
	}
	
	public void fazerPedido(int idCliente, ItemCardapio prato, Integer qtdePrato) {
	    Sessao.getPedidoAtual()
	      .adicionarPrato(prato, qtdePrato);
	}
}
