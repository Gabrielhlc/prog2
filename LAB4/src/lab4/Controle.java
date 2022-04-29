package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta classe � respons�vel por manipular as a��es do controle de alunos. 
 * 
 * @author Gabriel
 * 
 */
public class Controle {
	
	/**
	 * Mapa que armazena todos os alunos cadastrados. A chave � a matr�cula do aluno, do tipo String, e o valor � o pr�prio aluno, do tipo Aluno.
	 */
	private HashMap<String, Aluno> mapaAlunos;
	
	/**
	 * Mapa que armazena todos os grupos cadastrados. A chave � o nome do grupo, que � considerado em mai�sculo para generaliza��o, e o valor � 
	 * o pr�prio grupo, do tipo Grupo.
	 */
	private HashMap<String, Grupo> mapaGrupos;
	
	/**
	 * ArrayList que armazena os alunos que responderam as quest�es. O Generics aponta para o tipo Aluno. 
	 */
	private ArrayList<Aluno> RespostasAlunos;
	
	/**
	 * Construtor de Controle que inicializa o mapa de Alunos, o mapa de Grupos e o ArrayList dos Alunos que responderam. 
	 */
	public Controle() {
		this.mapaAlunos = new HashMap<>();
		this.mapaGrupos = new HashMap<>();
		this.RespostasAlunos = new ArrayList<>();
	}
	
	/**
	 * Cadastra um aluno no controle, armazenando-o no mapa de Alunos.
	 * @param matricula A matr�cula do aluno a ser cadastrado, do tipo String.
	 * @param nome O nome do aluno a ser cadastrado, do tipo String.
	 * @param curso O curso do aluno a ser cadastrado, do tipo String.
	 * @return "MATR�CULA J� CADASTRADA!" caso a matr�cula j� esteja cadastrada. "CADASTRO REALIZADO!" caso o cadastro foi bem sucedido.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == true) {
			retorno = "MATR�CULA J� CADASTRADA!";
		} else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.mapaAlunos.put(matricula, aluno);
			retorno = "CADASTRO REALIZADO!";
		}
		return retorno;
	}
	
	/**
	 * M�todo auxiliar que verifica se a matr�cula j� existe no controle.
	 * @param matricula a matr�cula a ser verificada, do tipo String.
	 * @return true se a matr�cula existe no controle e false se n�o.
	 */
	public boolean verificaMatriculaExiste(String matricula) {
		boolean chave = false;
		if (this.mapaAlunos.containsKey(matricula)) {
			chave = true;
		}
		return chave;
	}
	
	/**
	 * Retorna a exibi��o de um aluno identificado por sua matr�cula. 
	 * @param matricula A matr�cula do aluno a ser exibido, do tipo String.
	 * @return A exibi��o do aluno caso esteja cadastrado. "Aluno n�o cadastrado" caso n�o esteja cadastrado.
	 */
	public String exibeAluno(String matricula) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == true) {
			Aluno aluno = this.mapaAlunos.get(matricula);
			retorno = "Aluno: " + aluno.toString();
			}
			else {
				retorno = "Aluno n�o cadastrado.";
			}	
		return retorno;
	}
	
	/**
	 * Cadastra um grupo no controle com sua restri��o de curso, armazenando-o no mapa de Grupos.
	 * @param nomeGrupo Nome do grupo a ser cadastrado, do tipo String.
	 * @param restricao Restri��o de curso do grupo, do tipo String.
	 * @return "GRUPO J� CADASTRADO!" caso o grupo j� esteja cadastrado no controle. "CADASTRO REALIZADO!" caso o grupo for cadastrado.
	 */
	public String cadastraGrupo(String nomeGrupo, String restricao) {
		String retorno = "";
		String nomeChave = nomeGrupo.toUpperCase();
		if (verificaGrupoExiste(nomeChave) == true) {
			retorno = "GRUPO J� CADASTRADO!";
		}
		else {
			Grupo grupo = new Grupo(nomeChave, restricao);
			this.mapaGrupos.put(nomeChave, grupo);
			retorno = "CADASTRO REALIZADO!";
		}
		return retorno;
	}
	
	/**
	 * M�todo auxiliar que verifica se o grupo j� existe no controle.
	 * @param nomeGrupo Nome do grupo a ser verificado, do tipo String.
	 * @return true se o grupo j� exista no controle e false se n�o
	 */
	public boolean verificaGrupoExiste(String nomeGrupo) {
		boolean chave = false;
		if (this.mapaGrupos.containsKey(nomeGrupo.toUpperCase())) {
			chave = true;
		}
		return chave;
	}
	
	/**
	 * Aloca um aluno em um grupo.
	 * @param matricula A matr�cula do aluno a ser alocado, do tipo String.
	 * @param nomeGrupo O nome do grupo que ter� um aluno alocado, do tipo String.
	 * @return "Aluno n�o cadastrado" caso o aluno n�o exista no controle. "Grupo n�o cadastrado." caso o grupo n�o exista no controle. "GRUPO
	 * COM RESTRI��O DE CURSO" caso o curso do aluno n�o se encaixe a restri��o do grupo. "ALUNO ALOCADO" caso a aloca��o foi bem sucedida.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == false) {
			retorno = "Aluno n�o cadastrado";
		}
		else if (verificaGrupoExiste(nomeGrupo) == false) {
			retorno = "Grupo n�o cadastrado.";
		}
		else if (!this.mapaAlunos.get(matricula).getCurso().equals(this.mapaGrupos.get(nomeGrupo.toUpperCase()).getRestricao()) && (!this.mapaGrupos.get(nomeGrupo.toUpperCase()).getRestricao().equals(""))) {
			retorno = "GRUPO COM RESTRI��O DE CURSO";
		}
		else {
			this.mapaGrupos.get(nomeGrupo.toUpperCase()).setAluno(matricula);
			retorno = "ALUNO ALOCADO";
		}
		return retorno;
	}
	
	/**
	 * Verifica a pertin�ncia de um aluno em um grupo. 
	 * @param nomeGrupo Nome do grupo a ser verificado, do tipo String.
	 * @param matricula Matr�cula do aluno, do tipo String.
	 * @return "GRUPO N�O CADASTRADO" caso o grupo n�o exista no controle. "ALUNO PERTENCE AO GRUPO" caso o aluno pertence ao grupo. "ALUNO N�O
	 * PERTENCE AO GRUPO" caso o aluno n�o pertence ao grupo.
	 */
	public String pertinenciaGrupo(String nomeGrupo, String matricula) {
		String retorno = "";
		boolean pertence = false;
		if (verificaGrupoExiste(nomeGrupo) == false || this.mapaGrupos.get(nomeGrupo.toUpperCase()) == null) {
			retorno = "GRUPO N�O CADASTRADO.";
		}
		else {
			for (String alocados : this.mapaGrupos.get(nomeGrupo.toUpperCase()).getAlunosAlocados()) {
				if (alocados.equals(matricula)) {
					retorno = "ALUNO PERTENCE AO GRUPO";
					pertence = true;
					break;
				}
			}
		}
		if (pertence == false) {
			retorno = "ALUNO N�O PERTENCE AO GRUPO";
		}
		return retorno;
	}
	
	/**
	 * Cadastra os alunos que responderam as quest�es no quadro, armazenando-os no ArrayList de Alunos que responderam.
	 * @param matricula A matr�cula do aluno a ser cadastrado, do tipo String.
	 * @return "Aluno n�o cadastrado" caso o aluno n�o exista no controle. "ALUNO REGISTRADO!" caso o cadastro foi bem sucedido.
	 */
	public String cadastraRespostas(String matricula) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == false) {
			retorno = "Aluno n�o cadastrado.";
		}
		else {
			Aluno aluno = this.mapaAlunos.get(matricula);
			RespostasAlunos.add(aluno);
			retorno = "ALUNO REGISTRADO!";
		}
		return retorno;
	}
	
	/**
	 * Exibe os alunos que responderam as quest�es no quadro.
	 * @return a Exibi��o de alunos que responderam as quest�es no quadro.
	 */
	public String ImprimeAlunosRespostas() {
		String retorno = "Alunos: ";
		int contador = 1;
		for (Aluno aluno : RespostasAlunos) {
			retorno += "\n" + contador + ": " + aluno.toString();
			contador++;
		}
		return retorno;
	}
	
	/**
	 * Exibe a quantidade de grupos que se restringem � um curso.
	 * @param curso O curso em quest�o, do tipo String.
	 * @return A exibi��o da quantidade de grupos que se restringem � esse curso.
	 */
	public String ImprimeRestricoes(String curso) {
		String retorno = "";
		int contador = 0;
		for (Grupo grupo : this.mapaGrupos.values()) {
			if (grupo.getRestricao().equals(curso)) {
				contador++;
			}
		}
		retorno = curso + " " + contador;
		return retorno;
	}
}