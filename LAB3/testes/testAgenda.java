
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import agenda.Agenda;

/**
 * Classe para testar os caminhos que as funcionalidades que a classe Agenda possa tomar. 
 * 
 * @author Gabriel
 *
 */
public class testAgenda {
	
	/**
	 * A agenda a ser trabalhada nos testes.
	 */
	private Agenda agenda;
	
	/**
	 * Inicializa a agenda para os testes.
	 */
	@BeforeEach
	public void initAgenda() {
		this.agenda = new Agenda();
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição vazia, a primeira posição da agenda.
	 */
	@Test
	public void posicaoVazia0() {
		assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002"));
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição que já possui um contato cadastrado, substituindo-o. 
	 */
	@Test
	public void subtituiContato() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(1, "Felipe", "Silva", "(84) 98888- 1111", "(84) 98888-1112", "(84) 98888-1113"));
	}
	
	/**
	 * Testa o cadastro de um contato que já está cadastrado na agenda.
	 */
	@Test
	public void jaCadastrado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("CONTATO JÁ CADASTRADO", agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002"));
	}
	
	/**
	 * Testa o cadastro de um contato na posição 100, a posição limite da agenda.
	 */
	@Test 
	public void posicaoLimite100() {
		assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002"));
	}
	
	/**
	 * Testa o cadastro de um contato na posição logo acima do limite de agenda, a posição 101.
	 */
	@Test 
	public void posicaoInvalida101() {
		assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002"));
	}
	
	/**
	 * Testa o cadastro de um contato na posição logo abaixo da primeira posição da agenda, a posição 0.
	 */
	@Test
	public void posicaoInvalida0() {
		assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002"));
	}
	
	/**
	 * Testa o cadastro de um contato que não possui um dos três números. 
	 */
	@Test
	public void cadastroSemNumero() {
		assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", ""));
	}
	
	/**
	 * Testa a exibição de um contato que possui todos os dados.
	 */
	@Test
	public void exibirTodosDados() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("\nMatheus Gaudencio\n(83) 99999-0000 (Prioritário)\n(83) 99999-0001 (Whatsapp)\n(83) 99999-0002 (Adicional)\n", agenda.exibeContato(1));
	}
	
	/**
	 * Testa a exibição de um contato que não possui um dos três números.
	 */
	@Test
	public void exibirSem1Telefone() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "");
		assertEquals("\nMatheus Gaudencio\n(83) 99999-0000 (Prioritário)\n(83) 99999-0001 (Whatsapp)\n", agenda.exibeContato(1));
	}
	
	/**
	 * Testa a exibição de um contato em uma posição que não há um contato.
	 */
	@Test
	public void exibirPosicaoSemContato() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(100));
	}
	
	/**
	 * Testa a exibição de um contato em uma posição inválida da agenda, a posição 0, logo abaixo do limite de agenda. 
	 */
	@Test
	public void exibirLimiteInferior() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(0));
	}
	
	/**
	 * Testa a exibição de um contato em uma posição inválida da agenda, a posição 101, logo acima do limite de agenda.
	 */
	@Test
	public void exibitLimiteSuperior() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(101));
	}
	
	/**
	 * Testa a exibição de um contato favorito.
	 */
	@Test
	public void exibirFavoritado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.adicionaFavoritos(1,  1);
		assertEquals("\n❤️ Matheus Gaudencio\n(83) 99999-0000 (Prioritário)\n(83) 99999-0001 (Whatsapp)\n(83) 99999-0002 (Adicional)\n", agenda.exibeContato(1));
	}
	
	/**
	 * Testa a listagem de uma agenda vazia.
	 */
	@Test
	public void listarVazio() {
		assertEquals("", agenda.listaContatos());
	}
	
	/**
	 * Testar a listagem de contatos.
	 */
	@Test
	public void TestListarContatos() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("1 - Matheus Gaudencio\n", agenda.listaContatos());
	}
	
	/**
	 * Testa adicionar um contato aos favóritos. 
	 */
	@Test 
	public void TestAdicionaFavorito() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", agenda.adicionaFavoritos(1, 1));
	}
	
	/**
	 * Testa a listagem de favoritos.
	 */
	@Test 
	public void TestListarFavoritos() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.adicionaFavoritos(1, 1);
		assertEquals("1 - Matheus Gaudencio\n", agenda.listaFavoritos());
	}
	
	/**
	 * Testar exibir um contato que já foi favorito mas não é mais.
	 */
	@Test 
	public void exibirExFavoritado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		agenda.adicionaFavoritos(1, 1);
		agenda.cadastraContato(2, "Felipe", "Silva", "(84) 98888- 1111", "(84) 98888-1112", "(84) 98888-1113");
		agenda.adicionaFavoritos(2, 1);
		assertEquals("\nMatheus Gaudencio\n(83) 99999-0000 (Prioritário)\n(83) 99999-0001 (Whatsapp)\n(83) 99999-0002 (Adicional)\n", agenda.exibeContato(1));
	}
}
