package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta classe é responsável por manipular as ações do controle de alunos. 
 * 
 * @author Gabriel
 * 
 */
public class Controle {
	
	/**
	 * Mapa que armazena todos os alunos cadastrados. A chave é a matrícula do aluno, do tipo String, e o valor é o próprio aluno, do tipo Aluno.
	 */
	private HashMap<String, Aluno> mapaAlunos;
	
	/**
	 * Mapa que armazena todos os grupos cadastrados. A chave é o nome do grupo, que é considerado em maiúsculo para generalização, e o valor é 
	 * o próprio grupo, do tipo Grupo.
	 */
	private HashMap<String, Grupo> mapaGrupos;
	
	/**
	 * ArrayList que armazena os alunos que responderam as questões. O Generics aponta para o tipo Aluno. 
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
	 * @param matricula A matrícula do aluno a ser cadastrado, do tipo String.
	 * @param nome O nome do aluno a ser cadastrado, do tipo String.
	 * @param curso O curso do aluno a ser cadastrado, do tipo String.
	 * @return "MATRÍCULA JÁ CADASTRADA!" caso a matrícula já esteja cadastrada. "CADASTRO REALIZADO!" caso o cadastro foi bem sucedido.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == true) {
			retorno = "MATRÍCULA JÁ CADASTRADA!";
		} else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.mapaAlunos.put(matricula, aluno);
			retorno = "CADASTRO REALIZADO!";
		}
		return retorno;
	}
	
	/**
	 * Método auxiliar que verifica se a matrícula já existe no controle.
	 * @param matricula a matrícula a ser verificada, do tipo String.
	 * @return true se a matrícula existe no controle e false se não.
	 */
	public boolean verificaMatriculaExiste(String matricula) {
		boolean chave = false;
		if (this.mapaAlunos.containsKey(matricula)) {
			chave = true;
		}
		return chave;
	}
	
	/**
	 * Retorna a exibição de um aluno identificado por sua matrícula. 
	 * @param matricula A matrícula do aluno a ser exibido, do tipo String.
	 * @return A exibição do aluno caso esteja cadastrado. "Aluno não cadastrado" caso não esteja cadastrado.
	 */
	public String exibeAluno(String matricula) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == true) {
			Aluno aluno = this.mapaAlunos.get(matricula);
			retorno = "Aluno: " + aluno.toString();
			}
			else {
				retorno = "Aluno não cadastrado.";
			}	
		return retorno;
	}
	
	/**
	 * Cadastra um grupo no controle com sua restrição de curso, armazenando-o no mapa de Grupos.
	 * @param nomeGrupo Nome do grupo a ser cadastrado, do tipo String.
	 * @param restricao Restrição de curso do grupo, do tipo String.
	 * @return "GRUPO JÁ CADASTRADO!" caso o grupo já esteja cadastrado no controle. "CADASTRO REALIZADO!" caso o grupo for cadastrado.
	 */
	public String cadastraGrupo(String nomeGrupo, String restricao) {
		String retorno = "";
		String nomeChave = nomeGrupo.toUpperCase();
		if (verificaGrupoExiste(nomeChave) == true) {
			retorno = "GRUPO JÁ CADASTRADO!";
		}
		else {
			Grupo grupo = new Grupo(nomeChave, restricao);
			this.mapaGrupos.put(nomeChave, grupo);
			retorno = "CADASTRO REALIZADO!";
		}
		return retorno;
	}
	
	/**
	 * Método auxiliar que verifica se o grupo já existe no controle.
	 * @param nomeGrupo Nome do grupo a ser verificado, do tipo String.
	 * @return true se o grupo já exista no controle e false se não
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
	 * @param matricula A matrícula do aluno a ser alocado, do tipo String.
	 * @param nomeGrupo O nome do grupo que terá um aluno alocado, do tipo String.
	 * @return "Aluno não cadastrado" caso o aluno não exista no controle. "Grupo não cadastrado." caso o grupo não exista no controle. "GRUPO
	 * COM RESTRIÇÃO DE CURSO" caso o curso do aluno não se encaixe a restrição do grupo. "ALUNO ALOCADO" caso a alocação foi bem sucedida.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == false) {
			retorno = "Aluno não cadastrado";
		}
		else if (verificaGrupoExiste(nomeGrupo) == false) {
			retorno = "Grupo não cadastrado.";
		}
		else if (!this.mapaAlunos.get(matricula).getCurso().equals(this.mapaGrupos.get(nomeGrupo.toUpperCase()).getRestricao()) && (!this.mapaGrupos.get(nomeGrupo.toUpperCase()).getRestricao().equals(""))) {
			retorno = "GRUPO COM RESTRIÇÃO DE CURSO";
		}
		else {
			this.mapaGrupos.get(nomeGrupo.toUpperCase()).setAluno(matricula);
			retorno = "ALUNO ALOCADO";
		}
		return retorno;
	}
	
	/**
	 * Verifica a pertinência de um aluno em um grupo. 
	 * @param nomeGrupo Nome do grupo a ser verificado, do tipo String.
	 * @param matricula Matrícula do aluno, do tipo String.
	 * @return "GRUPO NÃO CADASTRADO" caso o grupo não exista no controle. "ALUNO PERTENCE AO GRUPO" caso o aluno pertence ao grupo. "ALUNO NÃO
	 * PERTENCE AO GRUPO" caso o aluno não pertence ao grupo.
	 */
	public String pertinenciaGrupo(String nomeGrupo, String matricula) {
		String retorno = "";
		boolean pertence = false;
		if (verificaGrupoExiste(nomeGrupo) == false || this.mapaGrupos.get(nomeGrupo.toUpperCase()) == null) {
			retorno = "GRUPO NÃO CADASTRADO.";
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
			retorno = "ALUNO NÃO PERTENCE AO GRUPO";
		}
		return retorno;
	}
	
	/**
	 * Cadastra os alunos que responderam as questões no quadro, armazenando-os no ArrayList de Alunos que responderam.
	 * @param matricula A matrícula do aluno a ser cadastrado, do tipo String.
	 * @return "Aluno não cadastrado" caso o aluno não exista no controle. "ALUNO REGISTRADO!" caso o cadastro foi bem sucedido.
	 */
	public String cadastraRespostas(String matricula) {
		String retorno = "";
		if (verificaMatriculaExiste(matricula) == false) {
			retorno = "Aluno não cadastrado.";
		}
		else {
			Aluno aluno = this.mapaAlunos.get(matricula);
			RespostasAlunos.add(aluno);
			retorno = "ALUNO REGISTRADO!";
		}
		return retorno;
	}
	
	/**
	 * Exibe os alunos que responderam as questões no quadro.
	 * @return a Exibição de alunos que responderam as questões no quadro.
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
	 * Exibe a quantidade de grupos que se restringem à um curso.
	 * @param curso O curso em questão, do tipo String.
	 * @return A exibição da quantidade de grupos que se restringem à esse curso.
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