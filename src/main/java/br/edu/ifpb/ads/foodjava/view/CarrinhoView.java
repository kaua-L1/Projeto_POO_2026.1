package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;
import br.edu.ifpb.ads.foodjava.controller.CarrinhoController;
public class CarrinhoView {
	Scanner sc = new Scanner(System.in);
	CarrinhoController controller = new CarrinhoController();
	public void carrinho() {
	    String op;

	    do {
	        System.out.println("----- Carrinho -----");
	        controller.mostrarPedidos();
	        System.out.println("1 - Confirmar Pedidos");
	        System.out.println("2 - Cancelar Pedidos");
	        System.out.println("0 - Voltar");
	        System.out.print("Escolha uma opção: ");

	        op = sc.nextLine().trim().toLowerCase();

	        if (op.equals("1") || op.equals("confirmar") || op.equals("confirmar pedidos")) {

	            controller.finalizarPedido();
	            System.out.println("Pedido realizado com sucesso! Você pode verificar seu status na opção 'Olhar Pedidos'.");

	        } else if (op.equals("2") || op.equals("cancelar") || op.equals("cancelar pedidos")) {

	            System.out.print("Digite o número do item: ");

	            while (!sc.hasNextInt()) {
	                System.out.println("Número inválido!");
	                sc.nextLine();
	                System.out.print("Digite o número do item: ");
	            }

	            int numero = sc.nextInt();
	            sc.nextLine();

	            controller.removerPedido(numero);
	            System.out.println("Item removido!");

	        } else if (!(op.equals("0") || op.equals("voltar"))) {

	            System.out.println("Opção inválida!");
	        }

	    } while (!(op.equals("0") || op.equals("voltar")));
	}
}