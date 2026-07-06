package br.edu.ifpb.ads.foodjava.model;

public class Restaurante extends Entidade{
	private String cnpj;
	private String categoriaCulinaria;
	
	public Restaurante() {
		
	}
	
	public Restaurante(String nomeFantasia, String email, String senha, String telefone, String endereco,String cnpj, String categoriaCulinaria) {
		super(nomeFantasia,email,senha,telefone,endereco);
		this.cnpj = cnpj;
		this.categoriaCulinaria = categoriaCulinaria;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCategoriaCulinaria() {
		return categoriaCulinaria;
	}

	public void setCategoriaCulinaria(String categoriaCulinaria) {
		this.categoriaCulinaria = categoriaCulinaria;
	}
	
	public String toString() {
		return "restaurante [cnpj=" + cnpj + ", categoriaCulinaria=" + categoriaCulinaria + "]";
	}
	
}
