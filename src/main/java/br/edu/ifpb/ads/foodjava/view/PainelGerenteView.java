package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;
import br.edu.ifpb.ads.foodjava.controller.PainelGerenteController;

public class PainelGerenteView {
	private Scanner sc = new Scanner(System.in);
	private ConfiguracaoRestauranteView restaurante = new ConfiguracaoRestauranteView();
	private PainelGerenteController controller = new PainelGerenteController();
	public PainelGerenteView() {
		
	}
	
	public void menu() {
		int op;
		do {
			System.out.println("--- Menu do Gerente ---");
			System.out.println("1-Gerenciar restaurante");
			System.out.println("2-Ver pedidos");
			System.out.println("3-Completar/editar dados pessoais");
			System.out.println("0-Sair");
			System.out.print("Escolha a opção: ");
			op = sc.nextInt();
			sc.nextLine();
			
			if(op == 1) {
				restaurante.menu();
			} else if(op == 3) {
				configurarDados();
			} else if(op == 2) {
				verPedidos();
			}
		}	while(op!=0);
	}

	public void configurarDados() {
		if(controller.gerenteCadastrado()) {
			System.out.print("Você já cadsatrou seus dados pessoais deseja alteralos?(S/N) ");
			if(sc.next().toLowerCase().equals("s")) {
				sc.nextLine();
				System.out.print("Digite seu nome: ");
				String nome = sc.nextLine();
				System.out.print("Digite seu telefone: ");
				String telefone = sc.nextLine();
				System.out.print("Digite seu endereço: ");
				String endereco = sc.nextLine();
				controller.cadastrarGerente(nome, telefone, endereco);
			}
		} else {
			System.out.print("Digite seu nome: ");
			String nome = sc.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = sc.nextLine();
			System.out.print("Digite seu endereço: ");
			String endereco = sc.nextLine();
			controller.cadastrarGerente(nome, telefone, endereco);
		}
	}
	
	public void verPedidos() {
		int count = 0;
		do {
			System.out.print(controller.mostrarPedidos());
			System.out.println("1- Filtrar por Status");
			System.out.println("2- Avançar pedido");
			System.out.println("3- Cancelar pedido");
			System.out.println("4- Resumo do dia");
			System.out.println("0- Voltar");
			count = sc.nextInt();
			sc.nextLine();
			
			if(count == 1) {
				System.out.println("Filtrar por qual estado? ");
				System.out.println("1- AGUARDANDO_CONFIRMACAO");
				System.out.println("2- CONFIRMADO");
				System.out.println("3- EM_PREPARO");
				System.out.println("4- SAIU_PARA_ENTREGA");
				System.out.println("5- ENTREGUE");
				System.out.print("0- Voltar");
				System.out.print("Escolha: ");
				int escolha = sc.nextInt();
				sc.nextLine();
				if(escolha==1) {
					menuFiltrado("AGUARDANDO_CONFIRMACAO");
				} else if(escolha == 2) {
					menuFiltrado("CONFIRMADO");
				} else if(escolha == 3) {
					menuFiltrado("EM_PREPARO");
				} else if(escolha == 4) {
					menuFiltrado("SAIU_PARA_ENTREGA");
				} else if(escolha == 5) {
					menuFiltrado("ENTREGUE");
				}
			} else if(count == 2) {
				avancarPedido();
			} else if(count == 3) {
				cancelarPedido();
			} else if(count  == 4) {
				System.out.println(controller.resumoDoDia());
			}
		}	while(count !=0);
	}
	
	public void menuFiltrado(String filtro) {
		int opcao = 0;
		do {
			System.out.print(controller.mostrarPedidos(filtro));
			System.out.println("1- Tirar filtro");
			System.out.println("2- Avançar pedido");
			System.out.println("3- Cancelar pedido");
			opcao = sc.nextInt();
			sc.nextLine();
			
			if(opcao == 1) {
				break;
			} else if(opcao == 2) {
				avancarPedido();
			} else if(opcao == 3) {
				cancelarPedido();
			} 
		} while(opcao!=0); 
		
	}
	
	public void avancarPedido() {
		System.out.println("Digite o ID do pedido que deseja avançar: ");
		controller.avancarPedido(sc.nextInt());	
		sc.nextLine();
		System.out.print("Pedido avançado com sucesso");
	}
	
	public void cancelarPedido() {
		System.out.println("Digite o ID do pedido que deseja cancelar: ");
		controller.cancelarPedido(sc.nextInt());
		sc.nextLine();
		System.out.print("Pedido Cancelado");
	}
}
