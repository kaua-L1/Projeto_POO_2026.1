package br.edu.ifpb.ads.foodjava.model;

public class ItemCardapio {
		private String nome;
		private String descricao;
		private float preco;
		private String categoria;
		private boolean disponivel;
		private String imagemPath;
		
		public ItemCardapio() {
			
		}
		
		public ItemCardapio(String nome, String descricao, float preco, String categoria, boolean disponivel) {
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.categoria = categoria;
			this.disponivel = disponivel;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public boolean getDisponivel() {
			return disponivel;
		}

		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}

		public String getImagemPath() {
			return imagemPath;
		}

		public void setImagemPath(String imagemPath) {
			this.imagemPath = imagemPath;
		}

		@Override
		public String toString() {
		    return "Nome: " + nome +
		           "\nDescrição: " + descricao +
		           "\nPreço: R$ " + preco +
		           "\nCategoria: " + categoria +
		           "\nDisponível: " + disponivel +
		           "\n-------------------------";
		}
		
		
}
