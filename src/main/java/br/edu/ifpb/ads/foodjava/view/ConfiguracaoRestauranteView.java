package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;
import br.edu.ifpb.ads.foodjava.controller.ConfiguracaoRestauranteController;

public class ConfiguracaoRestauranteView {
	private Scanner sc = new Scanner(System.in);
	private ConfiguracaoRestauranteController controller = new ConfiguracaoRestauranteController();
	
	public ConfiguracaoRestauranteView() {
		
	}
	
	public void menu() {
	    String op;

	    do {
	        System.out.println("--- Menu Restaurante ---");
	        System.out.println("1 - Adicionar prato ao cardápio");
	        System.out.println("2 - Importar cardápio");
	        System.out.println("3 - Editar item do cardápio");
	        System.out.println("4 - Excluir item do cardápio");
	        System.out.println("0 - Voltar");
	        System.out.print("Escolha a opção: ");
	        op = sc.nextLine().trim().toLowerCase();
	        if (op.equals("1") || op.equals("adicionar") || op.equals("adicionar prato") || op.equals("adicionar prato ao cardápio")) {
	            adicionarPrato();
	        } else if (op.equals("2") || op.equals("importar") || op.equals("importar cardápio")) {
	            importarCardapio();
	        } else if (op.equals("3") || op.equals("editar") || op.equals("editar item") || op.equals("editar item do cardápio")) {
	            editarItem();
	        } else if (op.equals("4") || op.equals("excluir") || op.equals("excluir item") || op.equals("excluir item do cardápio")) {
	            excluirItem();
	        } else if (!(op.equals("0") || op.equals("voltar"))) {
	            System.out.println("Opção inválida!");	        
	            }
	    } while (!(op.equals("0") || op.equals("voltar")));
	}
	
	public void adicionarPrato() {
		System.out.print("Diga o nome do prato: ");
		String nome = sc.nextLine();
		
		System.out.print("Diga a descrição do prato: ");
		String descricao = sc.nextLine();
		
		float preco;
		do {
		    System.out.print("Digite o preço do prato: ");
		    preco = sc.nextFloat();
		    if (preco <= 0) {
		        System.out.println("O preço deve ser maior que zero!");
		    }

		} while (preco <= 0);
		sc.nextLine();
		
		String categoria = "";
		String op;

		do {
		    System.out.println("Escolha a categoria do prato:");
		    System.out.println("1 - Entrada");
		    System.out.println("2 - Prato Principal");
		    System.out.println("3 - Sobremesa");
		    System.out.println("4 - Bebida");
		    System.out.print("Opção: ");

		    op = sc.nextLine().trim().toLowerCase();

		    if (op.equals("1") || op.equals("entrada")) {
		        categoria = "ENTRADA";
		    } else if (op.equals("2") || op.equals("prato principal") || op.equals("prato_principal")) {
		        categoria = "PRATO_PRINCIPAL";
		    } else if (op.equals("3") || op.equals("sobremesa")) {
		        categoria = "SOBREMESA";
		    } else if (op.equals("4") || op.equals("bebida") || op.equals("bebidas")) {
		        categoria = "BEBIDAS";
		    } else {
		        System.out.println("Categoria inválida!");
		    }

		} while (categoria.isEmpty());
		
		boolean disponivel = false;
		do {
		    System.out.println("Este prato está disponível?");
		    System.out.println("1 - Sim");
		    System.out.println("2 - Não");
		    System.out.print("Opção: ");

		    op = sc.nextLine().trim().toLowerCase();

		    if (op.equals("1") || op.equals("sim")) {
		        disponivel = true;
		        break;
		    } else if (op.equals("2") || op.equals("não") || op.equals("nao")) {
		        disponivel = false;
		        break;
		    } else {
		        System.out.println("Opção inválida! Digite 1, 2, Sim ou Não.");
		    }

		} while (true);
		
		controller.adicionarItem(nome, descricao, preco, categoria, disponivel);
	}
	
	public void importarCardapio() {
		System.out.print("Digite o caminho do json: ");
		controller.importarCardapio(sc.nextLine());
		System.out.print("Cardápio importado com sucesso.");
	}
	
	public void excluirItem() {
		System.out.println(controller.listarCardapio());
		System.out.println("0- Voltar");
		System.out.print("Digite o indice do prato:");
		int prato = sc.nextInt()-1;
		sc.nextLine();
		if(prato !=-1 ) {
			System.out.print(controller.escolherItem(prato));
			System.out.println("Você quer excluir?(S/N)");
			String opcao = sc.nextLine();
			if(opcao.equals("S")) {
				controller.excluirItem(prato);
				System.out.println("Item excluido com sucesso");
			}
		}
	}
	
	public void editarItem() {
		System.out.println(controller.listarCardapio());
		System.out.println("0- Voltar");
		System.out.print("Digite o indice do prato:");
		int prato = sc.nextInt()-1;
		sc.nextLine();
		
		if (prato != -1) {
		    System.out.println(controller.escolherItem(prato));
		    String op;
		    do {
		        System.out.println("O que você deseja mudar?");
		        System.out.println("1 - Nome");
		        System.out.println("2 - Descrição");
		        System.out.println("3 - Preço");
		        System.out.println("4 - Categoria");
		        System.out.println("5 - Disponibilidade");
		        System.out.println("0 - Nada");
		        System.out.print("Opção: ");
		        op = sc.nextLine().trim();
		        if (op.equals("1")) {
		            System.out.print("Digite o novo nome do prato: ");
		            controller.alterarNomePrato(sc.nextLine(), prato);
		            break;
		        } else if (op.equals("2")) {
		            System.out.print("Digite a nova descrição do prato: ");
		            controller.alterarDescricaoPrato(sc.nextLine(), prato);
		            break;
		        } else if (op.equals("3")) {
		            float preco;
		            do {
		                System.out.print("Digite o novo preço do prato: ");
		                preco = sc.nextFloat();
		                sc.nextLine();
		                if (preco <= 0) {
		                    System.out.println("O preço deve ser maior que zero.");
		                }
		            } while (preco <= 0);
		            controller.alterarPrecoPrato(preco, prato);
		            break;
		        } else if (op.equals("4")) {
		            String categoria = "";
		            String escolha;
		            do {
		                System.out.println("Escolha a nova categoria:");
		                System.out.println("1 - Entrada");
		                System.out.println("2 - Prato Principal");
		                System.out.println("3 - Sobremesa");
		                System.out.println("4 - Bebida");
		                System.out.print("Opção: ");
		                escolha = sc.nextLine().trim().toLowerCase();
		                if (escolha.equals("1") || escolha.equals("entrada")) {
		                    categoria = "ENTRADA";
		                } else if (escolha.equals("2")
		                        || escolha.equals("prato principal")
		                        || escolha.equals("prato_principal")) {
		                    categoria = "PRATO_PRINCIPAL";
		                } else if (escolha.equals("3")
		                        || escolha.equals("sobremesa")) {
		                    categoria = "SOBREMESA";
		                } else if (escolha.equals("4")
		                        || escolha.equals("bebida")
		                        || escolha.equals("bebidas")) {
		                    categoria = "BEBIDAS";
		                } else {
		                    System.out.println("Categoria inválida!");
		                }

		            } while (categoria.isEmpty());
		            controller.alterarCategoriaPrato(categoria, prato);
		            break;
		        } else if (op.equals("5")) {
		            String resposta;
		            boolean disponivel;
		            do {
		                System.out.println("O prato ainda está disponível?");
		                System.out.println("1 - Sim");
		                System.out.println("2 - Não");
		                System.out.print("Opção: ");
		                resposta = sc.nextLine().trim().toLowerCase();
		                if (resposta.equals("1") || resposta.equals("sim")) {
		                    disponivel = true;
		                    controller.alterarDisponiblidadePrato(disponivel, prato);
		                    break;
		                } else if (resposta.equals("2")
		                        || resposta.equals("não")
		                        || resposta.equals("nao")) {
		                    disponivel = false;
		                    controller.alterarDisponiblidadePrato(disponivel, prato);
		                    break;
		                } else {
		                    System.out.println("Opção inválida!");
		                }
		            } while (true);
		            break;
		        } else if (op.equals("0")) {
		            break;
		        } else {
		            System.out.println("Opção inválida!");
		        }
		    } while (true);
		    System.out.println("Alteração realizada com sucesso!");
		}
	}
}
