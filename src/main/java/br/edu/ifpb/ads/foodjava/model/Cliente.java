package br.edu.ifpb.ads.foodjava.model;

public class Cliente extends Entidade{
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String email, String senha, String telefone, String endereco) {
		super(nome,email,senha,telefone,endereco);
	}
	
}
