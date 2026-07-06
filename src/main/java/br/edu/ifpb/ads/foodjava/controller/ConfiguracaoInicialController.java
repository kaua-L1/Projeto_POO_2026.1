package br.edu.ifpb.ads.foodjava.controller;
import br.edu.ifpb.ads.foodjava.model.*;
import br.edu.ifpb.ads.foodjava.repository.*;
import br.edu.ifpb.ads.foodjava.util.ValidadorCNPJ;

public class ConfiguracaoInicialController {
	private RestauranteRepository restauranteRepository = new RestauranteRepository();
	private GerenteRepository gerenteRepository = new GerenteRepository();
	
	public ConfiguracaoInicialController() {
		
	}
	
	public boolean ehPrimeiraVez() {
		if(restauranteRepository.listar().isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void cadastrarRestaurante(String nomeFantasia, String email, String senha, String telefone, String endereco,String cnpj, String categoriaCulinaria) {
	
		if(ValidadorCNPJ.validar(cnpj)) {
			Restaurante restaurante = new Restaurante(nomeFantasia, email, senha, telefone, endereco,cnpj,categoriaCulinaria);
			restauranteRepository.salvar(restaurante);
		} else {
			System.out.println("CNPJ inválido.");
		}
	}
	
	public void cadastrarGerente(String email, String senha) {
		Gerente gerente = new Gerente("",email,senha,"","");
		gerenteRepository.salvar(gerente);
	}
}
