package agenda;

/**
 * Classe responsável por manipular o nome, sobrenome, número prioritário, número whatsapp e número adicional do contato.
 * 
 * @author Gabriel
 *
 */
public class Contato {
	
	/**
	 * String que representa o nome do contato.
	 */
	private String nome;
	
	/**
	 * String que representa o sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * String que representa o número prioritário do contato.
	 */
	private String prioritario;
	
	/**
	 * String que representa o número whatsapp do contato.
	 */
	private String whatsapp;
	
	/**
	 * String que representa o número adicional do contato.
	 */
	private String adicional;
	
	/**
	 * Construtor que cria o contato.
	 * @param nome O nome do contato.
	 * @param sobrenome O sobrenome do contato.
	 * @param prioritario O número prioritário do contato.
	 * @param whatsapp O número whatsapp do contato.
	 * @param adicional O número adicional do contato.
	 */
	public Contato(String nome, String sobrenome, String prioritario, String whatsapp, String adicional) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.prioritario = prioritario;
		this.whatsapp = whatsapp;
		this.adicional = adicional;
		
	}
	
	/**
	 * Retorna o nome do contato em questão.
	 * @return O nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o sobrenome do contato em questão.
	 * @return O sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna o número prioritário do contato em questão.
	 * @return O número prioritário do contato.
	 */
	public String getPrioritario() {
		return this.prioritario;
	}
	
	/**
	 * Retorna o número whatsapp do contato em questão. 
	 * @return O número whatsapp do contato.
	 */
	public String getWhatsapp() {
		return this.whatsapp;
	}
	
	/**
	 * Retorna o número adicional do contato em questão.
	 * @return O número adicional do contato.
	 */
	public String getAdicional() {
		return this.adicional;
	}

	/**
	 * Compara dois contatos e retorna um booleano informando se os dois contatos são o mesmo contato.
	 * Retorna true caso são iguais e false caso são diferentes.
	 * @param contato O contato a ser comparado. 
	 * @return true caso são iguais e false caso são diferentes.
	 */
	public boolean equalsContato(Contato contato) {
		if (contato != null) {
			if (this.getNome().equals(contato.getNome()) && this.getSobrenome().equals(contato.getSobrenome())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}