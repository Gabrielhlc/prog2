package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menu que permite ao usuário a livre manipulação de sua agenda.
 * 
 * @author Gabriel Carvalho
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a para efetuar as ações da agenda.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema e efetua as ações da agenda.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			System.out.println(recebeContato(scanner, agenda));
			break;
		case "L":
			System.out.println(agenda.listaContatos());
			break;
		case "E":
			System.out.print("\nQual contato> ");
			int posicaoE = scanner.nextInt();
			System.out.println(agenda.exibeContato(posicaoE));
			break;
		case "S":
			System.out.println("\nVlw flw o/");
			System.exit(0);
			break;
		case "F":
			System.out.println(agenda.listaFavoritos());
			break;
		case "A":
			System.out.print("\nContato> ");
			int contatoAFavoritar = scanner.nextInt();
			scanner.nextLine();
			System.out.print("\nPosição> ");
			int posicaoAFavoritar = scanner.nextInt();
			System.out.println(agenda.adicionaFavoritos(contatoAFavoritar, posicaoAFavoritar));
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Método estático que recebe todos os dados do contato a ser adicionado, adiciona o contato e retorna uma String que informa se o 
	 * contato foi cadastrado ou não. 
	 * @param scanner para receber os dados do contato pelas entradas do usuário.
	 * @param agenda a agenda a ser trabalhada.
	 * @return A String "CADASTRO REALIZADO" caso o cadastro foi um sucesso, "POSIÇÃO INVÁLIDA" caso a posição fornecida ultrapasse o 
	 * limite da quantidade de contatos permitida e "CONTATO JÁ CADASTRADO" caso o contato já esteja cadastrado nessa agenda.
	 */
	private static String recebeContato(Scanner scanner, Agenda agenda) {
		System.out.print("\nPosição na agenda: ");
		int posicaoC = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome: ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nPrioritario: ");
		String prioritario = scanner.nextLine();
		System.out.print("\nWhatsapp: ");
		String whatsapp = scanner.nextLine();
		System.out.print("\nAdicional: ");
		String adicional = scanner.nextLine();
		return agenda.cadastraContato(posicaoC, nome, sobrenome, prioritario, whatsapp, adicional);		
	}
	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
