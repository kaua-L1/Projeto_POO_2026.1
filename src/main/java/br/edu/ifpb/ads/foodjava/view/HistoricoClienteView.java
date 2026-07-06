package br.edu.ifpb.ads.foodjava.view;
import br.edu.ifpb.ads.foodjava.controller.HistoricoClienteController;
import br.edu.ifpb.ads.foodjava.util.Sessao;
public class HistoricoClienteView {
	private HistoricoClienteController controller = new HistoricoClienteController(); 
	
	public void Pedidos() {
	System.out.println(controller.mostrarHistorico(Sessao.getClienteLogado().getId()));	
	}
}
