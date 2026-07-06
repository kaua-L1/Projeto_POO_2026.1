package br.edu.ifpb.ads.foodjava.controller;
import br.edu.ifpb.ads.foodjava.model.Cardapio;
import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.repository.CardapioRepository;

public class ConfiguracaoRestauranteController {
	CardapioRepository repository = new CardapioRepository();
	
	public ConfiguracaoRestauranteController() {
		
	}
	
	public void adicionarItem(String nome, String descricao, float preco, String categoria, boolean disponivel) {
		ItemCardapio item = new ItemCardapio(nome, descricao,preco,categoria,disponivel);
		Cardapio cardapio = repository.buscar();
		cardapio.adicionarItem(item);
		repository.salvar(cardapio);
	}
	
	public void importarCardapio(String caminhoArquivo) {
	    Cardapio importado = repository.importar(caminhoArquivo);
	    Cardapio cardapio = repository.buscar();

	    for (ItemCardapio item : importado.getCardapio()) {
	        cardapio.adicionarItem(item);
	    }
	    repository.salvar(cardapio);
	}
	
	public String listarCardapio() {
		Cardapio cardapio = repository.buscar();
		String texto = "";
		int indice = 1;
		for (int i = 0; i < cardapio.getCardapio().size(); i++) {
		    ItemCardapio item = cardapio.getCardapio().get(i);
		    texto += "" + indice +"- " +item.getNome() +"\n";
		    indice++;
		}
		return texto;
	}
	
	public void excluirItem(int indice) {
		Cardapio cardapio = repository.buscar();
		cardapio.removerItem(indice);
		repository.salvar(cardapio);
	}
	
	public ItemCardapio escolherItem(int id) {
		Cardapio cardapio = repository.buscar();
		return cardapio.getCardapio().get(id);
	}
	
	public void alterarNomePrato(String nome,int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.getCardapio().get(id).setNome(nome);
		repository.salvar(cardapio);
	}
	
	public void alterarDescricaoPrato(String descricao, int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.getCardapio().get(id).setDescricao(descricao);
		repository.salvar(cardapio);
	}
	
	public void alterarPrecoPrato(float preco, int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.getCardapio().get(id).setPreco(preco);
		repository.salvar(cardapio);
	}
	
	public void alterarCategoriaPrato(String categoria, int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.getCardapio().get(id).setCategoria(categoria);
		repository.salvar(cardapio);
	}
	
	public void alterarDisponiblidadePrato(boolean disponivel,int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.getCardapio().get(id).setDisponivel(disponivel);
		repository.salvar(cardapio);
	}
	
	public void excluirPrato(int id) {
		Cardapio cardapio = repository.buscar();
		cardapio.removerItem(id);
		repository.salvar(cardapio);
	}
}

