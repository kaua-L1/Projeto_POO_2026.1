package br.edu.ifpb.ads.foodjava.model;
import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	private List<ItemCardapio> cardapio = new ArrayList<>();
	
	public Cardapio() {
		cardapio = new ArrayList<>();
	}
	
	public void adicionarItem(ItemCardapio itens) {
		this.cardapio.add(itens);
	}
	
	public void removerItem(int id) {
		cardapio.remove(id);
	}
	
	public void removerItem(ItemCardapio itens) {
		this.cardapio.remove(itens);
	}
	
	public ItemCardapio getItem(String nome) {
		for(int i = 0; i<cardapio.size();i++) {
			if(nome.equals(cardapio.get(i).getNome())) {
				return cardapio.get(i);
			}
		}
		return null;
	}

	public List<ItemCardapio> getCardapio() {
		return cardapio;
	}

	public void setCardapio(List<ItemCardapio> itens) {
		this.cardapio = itens;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("Cardápio\n");

	    for (ItemCardapio item : cardapio) {
	        sb.append(item).append("\n");
	    }

	    return sb.toString();
	}
	
	
}
