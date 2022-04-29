package lab4;

/**
 * Classe que manipula os atributos e métodos próprios de cada aluno.
 * @author Gabriel
 *
 */
public class Aluno {
	
	/**
	 * A matrícula do aluno, do tipo String.
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
	 * @param matricula A matrícula do aluno, do tipo String.
	 * @param nome O nome do aluno, do tipo String.
	 * @param curso O curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Método que retorna a matrícula de um aluno específico.
	 * @return A matrícula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Método que retorna o nome de um aluno específico.
	 * @return O nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método que retorna o curso de um aluno específico.
	 * @return O curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * Método que retorna a representação de um aluno em String.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}