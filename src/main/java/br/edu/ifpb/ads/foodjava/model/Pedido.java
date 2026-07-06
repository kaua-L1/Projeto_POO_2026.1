package br.edu.ifpb.ads.foodjava.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
	private int id;
	private int idCliente;
	private LocalDateTime hora;
	private List<ItemCardapio> pratos = new ArrayList<>();
	private List<Integer> qtdePrato = new ArrayList<>();
	private float valorTotal;
	private int status;
	
	public Pedido(int idCliente) {
	    this.idCliente = idCliente;
	    this.hora = LocalDateTime.now();
	    this.status = 1;
	}
	
	public Pedido() {
	    this.hora = LocalDateTime.now();
	    this.status = 1;
	}
	
	public Pedido(int idCliente,ItemCardapio prato, Integer qtdePrato) {
		id = 0;
		this.idCliente = idCliente;
		hora = LocalDateTime.now();
		this.pratos.add(prato);
		this.qtdePrato.add(qtdePrato);
		valorTotal = valorTotal();
		status = 1;
	}	 
	
	private float valorTotal() {
		float valor = 0;
		for(int i = 0; i<pratos.size();i++) {
			valor += pratos.get(i).getPreco()*qtdePrato.get(i);
		}	return valor;
	}
	
	public String getStatus() {
		if(status==1) {
			return "AGUARDANDO_CONFIRMACAO";
		} else if(status==2) {
			return "CONFIRMADO";
		} else if(status==3) {
			return "EM_PREPARO";
		} else if(status==4) {
			return "SAIU_PARA_ENTREGA";
		} else if(status==5) {
			return "ENTREGUE";
		} else if(status==6) {
			return "CANCELADO_GERENTE";
		} return "CANCELADO_CLIENTE";
	}
	
	public void cancelar() {
		status = 6;
	}
	
	public void avancarStatus() {
		if(status==5) {
			System.out.print("O pedido já está pronto");
		} else if(status<=0 || status>=6) {
			System.out.print("O pedido foi cancelado");
		}	else {
			status++;
			System.out.print("Pedido " + getStatus());
		}
	}
	
	public void adicionarPrato(ItemCardapio prato, int quantidade) {

	    pratos.add(prato);
	    qtdePrato.add(quantidade);

	    valorTotal = valorTotal();
	}
	
	public void removerPrato(int indice) {

	    pratos.remove(indice);
	    qtdePrato.remove(indice);	    
	    valorTotal = valorTotal();
	}

	public int getID() {
		return id;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public List<ItemCardapio> getPratos() {
		return pratos;
	}

	public void setPratos(List<ItemCardapio> pratos) {
		this.pratos = pratos;
	}

	public List<Integer> getQtdePrato() {
		return qtdePrato;
	}

	public void setQtdePrato(List<Integer> qtdePrato) {
		this.qtdePrato = qtdePrato;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String toStringCliente() {
	    String texto = "";

	    texto += "Pratos:\n";

	    for (int i = 0; i < pratos.size(); i++) {
	        texto += "- " + pratos.get(i).getNome()
	              + " x" + qtdePrato.get(i)
	              + " - R$ " + pratos.get(i).getPreco()
	              + "\n";
	    }

	    texto += "Total: R$ " + valorTotal;

	    return texto;
	}

	public String toString() {
	    String texto = "";

	    texto += "Pedido ID: " + id + "\n";
	    texto += "Cliente ID: " + idCliente + "\n";

	    texto += "Pratos:\n";
	    for (ItemCardapio prato : pratos) {
	        texto += "- " + prato.getNome() + "\n";
	    }

	    texto += "Status: " + getStatus() + "\n";
	    texto += "Total: R$ " + valorTotal + "\n";

	    return texto;
	}
}

