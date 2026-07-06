package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;
import br.edu.ifpb.ads.foodjava.controller.GerenciamentoCardapioController;
import br.edu.ifpb.ads.foodjava.util.Sessao;

public class GerenciamentoCardapioView {
	private GerenciamentoCardapioController controller = new GerenciamentoCardapioController();
	private Scanner sc = new Scanner(System.in);
	int pedido = 0;
	
	public void cardapioCliente() {
	System.out.println(controller.mostrarPorCategoria());
	System.out.println("0- Voltar");
	
	System.out.print("Digite o número do item que você deseja:");
	pedido = sc.nextInt();
	sc.nextLine();
	
	if(pedido!=0) {
		adicionarCarrinho();
	}
	}
	public void adicionarCarrinho() {
	    System.out.println(controller.escolherItem(pedido));
	    String resposta;
	    do {
	        System.out.print("Deseja comprar este item? (1-Sim / 2-Não): ");
	        resposta = sc.nextLine().trim().toLowerCase();
	        if (resposta.equals("1") || resposta.equals("sim")) {
	            int qtde;
	            do {
	                System.out.print("Digite a quantidade desejada: ");
	                qtde = sc.nextInt();
	                sc.nextLine();
	                if (qtde <= 0) {
	                    System.out.println("Quantidade inválida!");
	                }

	            } while (qtde <= 0);
	            controller.fazerPedido(
	                    Sessao.getClienteLogado().getId(),
	                    controller.escolherItem(pedido),
	                    qtde);
	            System.out.println("Pedido realizado com sucesso!");
	            break;
	        } else if (resposta.equals("2")
	                || resposta.equals("não")
	                || resposta.equals("nao")) {
	            break;
	        } else {
	            System.out.println("Opção inválida!");
	        }

	    } while (true);
	    cardapioCliente();
	}
}
