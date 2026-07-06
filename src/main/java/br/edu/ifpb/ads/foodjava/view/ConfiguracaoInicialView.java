package br.edu.ifpb.ads.foodjava.view;
import br.edu.ifpb.ads.foodjava.controller.ConfiguracaoInicialController;
import br.edu.ifpb.ads.foodjava.util.ValidadorCNPJ;
import java.util.Scanner;
public class ConfiguracaoInicialView {
	private ConfiguracaoInicialController controller = new ConfiguracaoInicialController();
	private Scanner sc = new Scanner(System.in);
	private LoginView login = new LoginView();
	private PainelGerenteView painelGerente = new PainelGerenteView();
	
	public ConfiguracaoInicialView() {
		if(controller.ehPrimeiraVez() == true) {
			System.out.println("É sua primeira vez aqui então cadastre o restaurante.");
			System.out.print("Digite o nome fantasia:");
			String nomeFantasia = sc.nextLine();
			
			System.out.print("Digite o email:");
			String email = sc.nextLine();
			
			System.out.print("Digite a senha:");
			String senha = sc.nextLine();
			
			System.out.print("Digite o telefone:");
			String telefone = sc.nextLine();
			
			System.out.print("Digite o endereço:");
			String endereco = sc.nextLine();
			
			String cnpj;
			while (true) {
			    System.out.print("Digite o CNPJ: ");
			    cnpj = sc.nextLine();
			    if (ValidadorCNPJ.validar(cnpj)) {
			        break;
			    }
			    System.out.println("CNPJ inválido! Tente novamente.\n");
			}
			System.out.print("Digite a categoria culinaria:");
			String categoriaCulinaria = sc.nextLine();
			
			System.out.println("Restaurante cadastrado com sucesso agr cadastre o login do gerente: ");
			System.out.print("Digite o email do Gerente: ");
			String emailGerente = sc.nextLine();
			
			System.out.print("Digite a senha do Gerente: ");
			String senhaGerente = sc.nextLine();
			
			controller.cadastrarRestaurante(nomeFantasia, email, senha, telefone, endereco, cnpj, categoriaCulinaria);
			controller.cadastrarGerente(emailGerente, senhaGerente);
			
			System.out.println("Login cadastrado com sucesso por favor preencha o restos de suas informções pessoais no menu do gerente.");
			painelGerente.menu();
		} else {
			login.menu();
		}
	}
}
