package lab4;

import java.util.ArrayList;

/**
 * Classe que manipula os atributos e m�todos pr�prios de cada grupo.
 * @author Gabriel
 *
 */
public class Grupo {
	
	/**
	 * O nome do grupo, do tipo String.
	 */
	private String nomeGrupo;
	
	/**
	 * A restri��o do grupo, do tipo String.
	 */
	private String restricao;
	
	/**
	 * ArrayList que armazena os alunos alocados no grupo. 
	 */
	private ArrayList<String> AlunosAlocados;
	
	/**
	 * Construtor que inicializa um grupo.
	 * @param nomeGrupo O nome do grupo, do tipo String.
	 * @param restricao A restri��o do grupo, do tipo String. 
	 */
	public Grupo(String nomeGrupo, String restricao) {
		this.nomeGrupo = nomeGrupo;
		this.restricao = restricao;
		this.AlunosAlocados = new ArrayList<>();
	}
	
	/**
	 * Armazena um aluno alocado no grupo no ArrayList de alunos alocados.
	 * @param matricula A matr�cula do aluno, do tipo String.
	 */
	public void setAluno(String matricula) {
		this.AlunosAlocados.add(matricula);
	}
	
	/**
	 * M�todo que retorna o nome de um grupo espec�fico.
	 * @return O nome do grupo.
	 */
	public String getNome() {
		return this.nomeGrupo;
	}
	
	/**
	 * M�todo que retorna a restri��o de um grupo espec�fico.
	 * @return A restri��o do grupo.
	 */
	public String getRestricao() {
		return this.restricao;
	}
	
	/**
	 * M�todo que retorna o ArrayList de alunos alocados de um grupo.
	 * @return o ArrayList de alunos alocado do grupo.
	 */
	public ArrayList<String> getAlunosAlocados() {
		return this.AlunosAlocados;
	}
}