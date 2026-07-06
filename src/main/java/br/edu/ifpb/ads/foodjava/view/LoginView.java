package br.edu.ifpb.ads.foodjava.view;
import java.util.Scanner;
import br.edu.ifpb.ads.foodjava.controller.LoginController;
import br.edu.ifpb.ads.foodjava.model.*;

public class LoginView {
	private LoginController controller = new LoginController();
	private Scanner sc = new Scanner(System.in);
	private PrincipalClienteView principalCliente = new PrincipalClienteView();
	private PainelGerenteView principalGerente = new PainelGerenteView();
	
	public void menu() {
	    String opcao;
	    do {
	        System.out.println("----- Menu Inicial -----");
	        System.out.println("1 - Login");
	        System.out.println("2 - Cadastro");
	        System.out.print("Escolha uma opção: ");
	        opcao = sc.nextLine().trim().toLowerCase();
	        if (opcao.equals("1") || opcao.equals("login")) {
	            login();
	            break;
	        } else if (opcao.equals("2") || opcao.equals("cadastro") || opcao.equals("cadastrar")) {
	            cadastro();
	            break;
	        } else {
	            System.out.println("Opção inválida!");
	        }

	    } while (true);
	}
	
	public void login() {
		System.out.print("Digite o email: ");
		String email = sc.nextLine();
		System.out.print("Digite a senha: ");
		String senha = sc.nextLine();
		Entidade usuario = controller.login(email, senha);
		
		if (usuario == null) {
		    System.out.println("Email ou senha inválidos.");
		} else if (usuario instanceof Cliente) {
		    principalCliente.Menu();
		} else if (usuario instanceof Gerente) {
		    principalGerente.menu();
		} else if (usuario instanceof Restaurante) {
		    System.out.println("Bem-vindo, restaurante " + usuario.getNome());
		}
	}
	
	public void cadastro() {
		System.out.println("Por favor insira os seguintes dados");
		System.out.print("Nome :");
		String nome = sc.nextLine();
		
		System.out.print("Email :");
		String email = sc.nextLine();
		
		String senha;
		do {
		    System.out.print("Senha: ");
		    senha = sc.nextLine();
		    if (senha.length() < 8 && !senha.matches(".*\\d.*")) {
		        System.out.println("A senha deve ter no mínimo 8 caracteres OU conter pelo menos um número.");
		    }
		} while (senha.length() < 8 && !senha.matches(".*\\d.*"));
		
		System.out.print("Telefone :");
		String telefone = sc.nextLine();
		
		System.out.print("Endereço :");
		String endereco = sc.nextLine();
		
		controller.cadastrarCliente(nome, email, senha, telefone, endereco);
		principalCliente.Menu();
	}
}
