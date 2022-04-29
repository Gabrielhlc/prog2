package lab4;
import java.util.Scanner;

/**
 * Classe que conduz a intera��o com o usu�rio e direciona suas escolhas.
 * 
 * @author Gabriel
 */
public class MainControle {
	
	public static void main(String[] args) {
		Controle controle = new Controle();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, scanner);
		}
		
	}
	
	/**
	 * Exibe a interface de menu e recebe a escolha do usu�rio.
	 * @param scanner Recebe a escolha do usu�rio.
	 * @return A escolha do usu�rio.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" +
						"(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" + 
						"(I)mprimir Alunos que Responderam\n" +
						"(O)xe, e a contagem dos grupos com restri��o de curso?\n" +
						"(S)im, quero fechar o programa!\n" +
						"\n" + 
						"Op��o> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Direciona o comando de escolha do usu�rio. 
	 * @param opcao A op��o desejada do usu�rio.
	 * @param controle O controle utilizado.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 */
	private static void comando(String opcao, Controle controle, Scanner scanner) {
		switch(opcao) {
		case "C":
				recebeCadastra(scanner, controle);
				break;
		case "E":
				recebeExibe(scanner, controle);
				break;
		case "N":
				recebeNovoGrupo(scanner, controle);
				break;
		case "A":
				AlocarOuPertinencia(scanner, controle);
				break;
		case "R":
				recebeCadastraRespostas(scanner, controle);
				break;
		case "I":
				MainImprimeRespostas(controle);
				break;
		case "O":
				recebeGrupoComRestricao(scanner, controle);
				break;
		case "S":
				System.exit(0);
				break;
		default: 
				System.out.println("Op��o inv�lida");
				System.exit(0);
		}
	}
		
	/**
	 * Recebe os dados do usu�rio para cadastrar um aluno.	
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utiilizado.
	 */
	private static void recebeCadastra(Scanner scanner, Controle controle) {
		System.out.println("\nMatr�cula:");
		String matricula = scanner.next();
		scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Curso:");
		String curso = scanner.nextLine();
		System.out.println(controle.cadastraAluno(matricula, nome, curso));
	}
	
	/**
	 * Recebe os dados do usu�rio para exibir um aluno.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utilizado.
	 */
	private static void recebeExibe(Scanner scanner, Controle controle) {
		System.out.println("Matr�cula: ");
		String matricula = scanner.next();
		scanner.nextLine();
		System.out.println(controle.exibeAluno(matricula));
	}
		
	/**
	 * Recebe os dados para cadastrar um novo grupo.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utilizado.
	 */
	private static void recebeNovoGrupo(Scanner scanner, Controle controle) {
		System.out.println("Grupo: ");
		scanner.nextLine();
		String nomeGrupo = scanner.nextLine();
		System.out.println("Restri��o? ");
		String restricao = scanner.nextLine();
		System.out.println(controle.cadastraGrupo(nomeGrupo, restricao));
	}
		
	/**
	 * Recebe os dados para alocar ou verificar a pertin�ncia de um aluno em um ugrpo.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utilizado.
	 */
	private static void AlocarOuPertinencia(Scanner scanner, Controle controle) {
		System.out.println("(A)locar Aluno ou (P)ertin�ncia a Grupo? ");
		scanner.nextLine();
		String opcao = scanner.nextLine();
		if (opcao.equals("A")) {
			System.out.println("Matricula: ");
			String matricula = scanner.nextLine();
			System.out.println("Grupo: ");
			String nomeGrupo = scanner.nextLine();
			System.out.println(controle.alocaAluno(matricula, nomeGrupo));
		}
		else { 
			System.out.println("Grupo: ");
			String nomeGrupo = scanner.nextLine();
			System.out.println("Aluno: ");
			String matricula = scanner.nextLine();
			System.out.println(controle.pertinenciaGrupo(nomeGrupo, matricula));
		}
	}
	
	/**
	 * Recebe os dados para cadastrar os alunos que responderam as quest�es no quadro.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utilizado.
	 */
	private static void recebeCadastraRespostas(Scanner scanner,Controle controle) {
		System.out.println("Matricula: ");
		String matricula = scanner.next();
		scanner.nextLine();
		System.out.println(controle.cadastraRespostas(matricula));
	}
	
	/**
	 * Imprime os alunos que responderam as quest�es no quadro.
	 * @param controle Controle utilizado.
	 */
	private static void MainImprimeRespostas(Controle controle) {
		System.out.println(controle.ImprimeAlunosRespostas());
	}
	
	/**
	 * Recebe os dados para exibir quantos grupos possuem restri��o para certo curso.
	 * @param scanner Scanner para ler as entradas do usu�rio.
	 * @param controle Controle utilizado.
	 */
	private static void recebeGrupoComRestricao(Scanner scanner, Controle controle) {
		System.out.println("Curso: ");
		String curso = scanner.next();
		System.out.println(controle.ImprimeRestricoes(curso));
	}
}