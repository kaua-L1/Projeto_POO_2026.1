package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;

public class PrincipalClienteView {
	private Scanner sc = new Scanner(System.in);
	private GerenciamentoCardapioView gerenciamentoCardapioView = new GerenciamentoCardapioView();
	private CarrinhoView carrinhoView = new CarrinhoView();
	private HistoricoClienteView historicoClienteView = new HistoricoClienteView();
	
	public void Menu() {
	    String op;

	    do {
	        System.out.println("--- Menu Cliente ---");
	        System.out.println("1 - Olhar cardápio");
	        System.out.println("2 - Olhar carrinho");
	        System.out.println("3 - Olhar pedidos");
	        System.out.println("0 - Sair");
	        System.out.print("Escolha a opção: ");

	        op = sc.nextLine().trim().toLowerCase();

	        if (op.equals("1") || op.equals("olhar cardápio") || op.equals("cardápio")) {
	            gerenciamentoCardapioView.cardapioCliente();

	        } else if (op.equals("2") || op.equals("olhar carrinho") || op.equals("carrinho")) {
	            carrinhoView.carrinho();

	        } else if (op.equals("3") || op.equals("olhar pedidos") || op.equals("pedidos")) {
	            historicoClienteView.Pedidos();

	        } else if (op.equals("0") || op.equals("sair")) {
	            break;

	        } else {
	            System.out.println("Opção inválida!");
	        }

	    } while (true);
	}
}
