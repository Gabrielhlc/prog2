package agenda;

/**
 * Uma agenda que mantém uma lista de contatos e uma lista de favoritos com posições. Podem existir até 100 contatos e até 10 favoritos. 
 * 
 * @author Gabriel Carvalho
 *
 */
public class Agenda {
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Cadastra um contato em uma posição da agenda. Caso já possua um contato na posição, o contato é substituido pelo que está sendo cadastrado.
	 * Caso a posição fornecida seja inválida, retorna que a posição é inválida. Caso já exista o contato que está sendo cadastrado nessa 
	 * agenda, retorna que o contato já está cadastrado.
	 * @param posicao A posição, na agenda, em que o contato será cadastrado.
	 * @param nome O nome do contato. 
	 * @param sobrenome O sobrenome do contato.
	 * @param prioritario O número prioritário do contato.
	 * @param whatsapp O número whatsapp do contato.
	 * @param adicional O número adicional do contato.
	 * @return String que informa se o cadastro foi realizado, se o contato já está cadastrado e se a posição é inválida.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String prioritario, String whatsapp, String adicional) {
		String retorno = "";
		if (posicao <= 0 || posicao > 100) {
			retorno = "POSIÇÃO INVÁLIDA";
		} else {
			boolean cadastrado = false;
			for (int i = 0;i<contatos.length;i++) {
				if (contatos[i] != null) {
					if (nome.equals(contatos[i].getNome()) && sobrenome.equals(contatos[i].getSobrenome())) {
						retorno = "CONTATO JÁ CADASTRADO";
						cadastrado = true;
					}
				}
			}
			if (cadastrado == false) {
			contatos[posicao-1] = new Contato(nome, sobrenome, prioritario, whatsapp, adicional);
			retorno = "CADASTRO REALIZADO";
			}
		}
		return retorno;
	}
		
	/**
	 * Imprime a lista de contato da agenda em questão.
	 * @return String que representa a listagem de contatos da agenda.
	 */
	public String listaContatos() {
		String retorno = "";
		Contato[] contatos = this.getContatos();
		for (int j = 0; j < contatos.length; j++) {
			if (contatos[j] != null) {
				retorno += formataContato(j) + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Imprime um contato referenciado pela sua posição como parâmetro e todos os seus dados. 
	 * Caso a posição seja inválida ou não exista nenhum contato referenciado por essa posição, possui um retorno que informa que a posição é inválida.
	 * Caso o contato escolhido é um favorito, exibe também um coração ao seu lado simbolizando que é favorito.
	 * @param posicao A posição na agenda que referencia o contato.
	 * @return String que representa a exibição do contato.
	 */
	public String exibeContato(int posicao) {
		String retorno = "";
		if (posicao < 1 || posicao > 100) {
			retorno = "POSIÇÃO INVÁLIDA!"; 
		} else { 
			Contato contato = this.getContato(posicao);
			if (contato == null) {
				retorno = "POSIÇÃO INVÁLIDA!";
			} else { 
				boolean ehFavorito = false;
				for (int i = 0; i<favoritos.length;i++) {
					if (contato.equalsContato(favoritos[i])) {
						retorno += "\n❤️ " + contato.getNome() + " " + contato.getSobrenome();
						ehFavorito = true;
					}
				}
				if (ehFavorito == false) {
					retorno += "\n" + contato.getNome() + " " + contato.getSobrenome();
				}
				if (!contato.getPrioritario().equals("") && !contato.getPrioritario().equals("\"\"")) {
					retorno += "\n" + contato.getPrioritario() + " (Prioritário)";
				}
				if (!contato.getWhatsapp().equals("") && !contato.getWhatsapp().equals("\"\"")) {
					retorno += "\n" + contato.getWhatsapp() + " (Whatsapp)";
				}
				if (!contato.getAdicional().equals("") && !contato.getAdicional().equals("\"\"")) {
					retorno += "\n" + contato.getAdicional() + " (Adicional)";
				}
				retorno +="\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Formata um contato para impressão na interface. 
	 * Formata para imprimir apenas sua posição, seu nome e seu sobrenome.  
	 * @param posicao A posição do contato 
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	public String formataContato(int posicao) {
		return (posicao+1) + " - " + contatos[posicao].getNome() + " " + contatos[posicao].getSobrenome();
	}
	
	/**
	 * Acessa a lista de contatos mantida e retorna o array de contatos da agenda em questão.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao-1];
	}
	
	
	// PARTE PARA TRABALHAR OS FAVORITOS.
	
	/**
	 * Acessa a lista de favoritos mantida e retorna o array de favoritos da agenda em questão.
	 * @return O array de favoritos da agenda.
	 */
	public Contato[] getFavoritos() {
		return favoritos.clone();
	}
	
	/** 
	 * Adiciona um contato, referenciado pela sua posição no array de contatos, aos favoritos, de acordo com a posição que deseja favoritar 
	 * no array de favoritos. Caso o contato já esteja favoritado em alguma outra posição, não é permitido que o mesmo seja favoritado na posição desejada.
	 * @param contatoAFavoritar A posição que referencia o contato que deve ser favoritado.
	 * @param posicaoAFavoritar A posição desejada que o contato seja favoritado.
	 * @return
	 */
	public String adicionaFavoritos(int contatoAFavoritar, int posicaoAFavoritar) {
		String retorno = "";
		boolean jaFavoritado = false;
		for (int i = 0;i<favoritos.length;i++) {
			if (favoritos[i] != null) {
				if (contatos[contatoAFavoritar -1].equalsContato(favoritos[i])) {
					jaFavoritado = true; 
					break;
				}
			}
		}
		if (jaFavoritado == false) {
			this.favoritos[posicaoAFavoritar -1] = contatos[contatoAFavoritar -1];
			retorno = "CONTATO FAVORITADO NA POSIÇÃO " + posicaoAFavoritar + "!";
		}
		return retorno;
	}
	
	/**
	 * Formata um favorito para impressão na interface. 
	 * Formata para imprimir apenas sua posição, seu nome e seu sobrenome. 
	 * @param posicao
	 * @return
	 */
	public String formataFavoritos(int posicao) {
		return (posicao+1) + " - " + favoritos[posicao].getNome()  + " " + favoritos[posicao].getSobrenome();
	}
	
	/**
	 * Imprime a lista de favoritos da agenda em questão.
	 * @return String que representa a listagem de favoritos da agenda.
	 */
	public String listaFavoritos() {
		String retorno = "";
		Contato[] favoritos = this.getFavoritos();
		for (int i = 0; i<favoritos.length; i++) {
			if (favoritos[i] != null) {
				retorno += formataFavoritos(i) +"\n";
			}
		}
		return retorno;
	}
}