package br.edu.ifpb.ads.foodjava.controller;
import br.edu.ifpb.ads.foodjava.model.*;
import br.edu.ifpb.ads.foodjava.repository.*;
import br.edu.ifpb.ads.foodjava.util.Sessao;
public class LoginController {
	private RestauranteRepository restauranteRepository = new RestauranteRepository();
	private ClienteRepository clienteRepository = new ClienteRepository();
	private GerenteRepository gerenteRepository = new GerenteRepository();
	
	public LoginController() {
		
	}
	
	public Entidade login(String email, String senha) {
		if(buscarClienteEmail(email) != null) {
			Cliente cliente = buscarClienteEmail(email);
			if(cliente.getSenha().equals(senha) == true) {
				Sessao.setClienteLogado(cliente);
				Pedido pedido = new Pedido();
				pedido.setidCliente(cliente.getId());
				Sessao.setPedidoAtual(pedido);
				return cliente;
			} else {
				return null; /*ExceptionSenhaInvalida*/
			}
		} else if(buscarGerenteEmail(email) != null) {
			Gerente gerente = buscarGerenteEmail(email);
			if(gerente.getSenha().equals(senha) == true) {
				return gerente;
			} else {
				return null; /*ExceptionSenhaInvalida*/
			}
		} else if(buscarRestauranteEmail(email) != null) {
			Restaurante restaurante = buscarRestauranteEmail(email);
			if(restaurante.getSenha().equals(senha) == true) {
				return restaurante;
			} else {
				return null; /*ExceptionSenhaInvalida*/
			}
		} return null; /*ExceptionEmailnaoCadastrado*/
	}
	
	public boolean cadastrarCliente(String nome, String email, String senha, String telefone, String endereco) {
		Cliente cliente = new Cliente(nome,email,senha,telefone,endereco);
		clienteRepository.salvar(cliente);
		Sessao.setClienteLogado(cliente);
		Pedido pedido = new Pedido();
		pedido.setidCliente(cliente.getId());
		Sessao.setPedidoAtual(pedido);
		return true;
	}
	
	public boolean validarSenha(String senha) {
		if(senha.length()>=8 && senha.matches(".*\\d.*")) {
			return true;
		} else {return false;} /*ExceptionSenhaInvalida*/
	}
	
	public Cliente buscarClienteEmail(String email) {
	    for (Cliente cliente : clienteRepository.listar()) {
	        if(cliente.getEmail() == null) {
	        	continue;
	        } else {
	        	if (cliente.getEmail().equals(email)) {
		            return cliente;
		        }
	        }
	    }
	    return null;
	}
	
	public Gerente buscarGerenteEmail(String email) {
	    for (Gerente gerente : gerenteRepository.listar()) {
	        if(gerente.getEmail() == null) {
	        	continue;
	        } else {
	        	if (gerente.getEmail().equals(email)) {
		            return gerente;
		        }
	        }
	    }
	    return null;
	}
	
	public Restaurante buscarRestauranteEmail(String email) {
		for (Restaurante restaurante : restauranteRepository.listar()) {
	        if(restaurante.getEmail() == null) {
	        	continue;
	        } else {
	        	if (restaurante.getEmail().equals(email)) {
		            return restaurante;
		        }
	        }
	    }
	    return null;
	}
}
