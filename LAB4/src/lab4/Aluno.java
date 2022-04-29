package lab4;

/**
 * Classe que manipula os atributos e m�todos pr�prios de cada aluno.
 * @author Gabriel
 *
 */
public class Aluno {
	
	/**
	 * A matr�cula do aluno, do tipo String.
	 */
	private String matricula;
	
	/**
	 * O nome do aluno, do tipo String.
	 */
	private String nome;
	
	/**
	 * O curso doaluno, do tipo String.
	 */
	private String curso;
	
	/**
	 * Construtor que inicializa um aluno.
	 * @param matricula A matr�cula do aluno, do tipo String.
	 * @param nome O nome do aluno, do tipo String.
	 * @param curso O curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * M�todo que retorna a matr�cula de um aluno espec�fico.
	 * @return A matr�cula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * M�todo que retorna o nome de um aluno espec�fico.
	 * @return O nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * M�todo que retorna o curso de um aluno espec�fico.
	 * @return O curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * M�todo que retorna a representa��o de um aluno em String.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}