package br.edu.ifpb.ads.foodjava.controller;
import java.util.List;

import br.edu.ifpb.ads.foodjava.model.*;
import br.edu.ifpb.ads.foodjava.repository.*;

public class PainelGerenteController {
	private GerenteRepository gerenteRepository = new GerenteRepository();
	private ListaPedidosRepository listaPedidosRepository = new ListaPedidosRepository();
	
	public PainelGerenteController() {
		
	}
	
	public void cadastrarGerente(String nome, String telefone, String endereco) {

	    List<Gerente> gerentes = gerenteRepository.listar();

	    if (gerentes.isEmpty()) {
	        return;
	    }

	    Gerente gerente = gerentes.get(0);

	    gerente.setNome(nome);
	    gerente.setTelefone(telefone);
	    gerente.setEndereco(endereco);

	    gerenteRepository.atualizar(gerente);
	}
	
	public boolean gerenteCadastrado() {

	    List<Gerente> gerentes = gerenteRepository.listar();

	    if (gerentes.isEmpty()) {
	        return false;
	    }

	    Gerente gerente = gerentes.get(0);

	    return gerente.getNome() != null &&
	           !gerente.getNome().trim().isEmpty();
	}
	
	public String mostrarPedidos() {

	    String texto = "";

	    for (Pedido pedido : listaPedidosRepository.buscar().getPedidos()) {
	        texto += "Pedido ID: " + pedido.getID() + "\n";
	        texto += "Cliente ID: " + pedido.getIdCliente() + "\n";
	        texto += "Status: " + pedido.getStatus() + "\n";
	        texto += "Total: R$ " + pedido.getValorTotal() + "\n";
	        texto += "--------------------------\n";
	    }

	    return texto;
	}
	
	public String mostrarPedidos(String status) {

	    String texto = "";

	    for (Pedido pedido : listaPedidosRepository.buscar().getPedidos()) {

	        if (pedido.getStatus().equals(status)) {
	            texto += pedido.toString() + "\n";
	        }

	    }

	    return texto;
	}
	
	
	public void teste(int id) {
		ListaPedidos lista = listaPedidosRepository.buscar();
		Pedido pedido = lista.getPedido(id);

		System.out.println("Pedido encontrado: " + pedido);

		pedido.avancarStatus();
	}
	public void avancarPedido(int id) {
	    ListaPedidos lista = listaPedidosRepository.buscar();
	    lista.getPedido(id).avancarStatus();
	    listaPedidosRepository.salvar(lista);
	}
	public void cancelarPedido(int id) {
	    ListaPedidos lista = listaPedidosRepository.buscar();
	    if (lista.getPedido(id).getStatus().equals("AGUARDANDO_CONFIRMACAO")) {
	    	lista.getPedido(id).cancelar();
	        listaPedidosRepository.salvar(lista);
	    }
	}
	public String resumoDoDia() {

	    int pedidosEntregues = 0;
	    double faturamento = 0;

	    ListaPedidos lista = listaPedidosRepository.buscar();

	    if (lista != null) {
	        for (Pedido pedido : lista.getPedidos()) {
	            if (pedido.getStatus().equals("ENTREGUE")) {
	                pedidosEntregues++;
	                faturamento += pedido.getValorTotal();
	            }
	        }
	    }

	    StringBuilder sb = new StringBuilder();

	    sb.append("\n==============================");
	    sb.append("\n      RESUMO DO DIA");
	    sb.append("\n==============================");
	    sb.append("\nPedidos entregues: ").append(pedidosEntregues);
	    sb.append("\nFaturamento: R$ ").append(String.format("%.2f", faturamento));
	    sb.append("\n==============================");

	    return sb.toString();
	}
}
