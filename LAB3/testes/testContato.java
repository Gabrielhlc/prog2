
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import agenda.Contato;

/**
 * Classe responsável por testar os caminhos que as funcionalidades da classe Contato possa tomar.
 * @author Gabriel
 *
 */
public class testContato {
		
	/**
	 * O contato prioritário a ser usado nos testes.
	 */
	Contato contato1 = new Contato("Gabriel", "Carvalho", "(83) 112233445", "(83) 544332211", "(83) 123456789");
	
	/**
	 * O contato que será usado caso algum teste necessite de um segundo contato.
	 */
	Contato contato2 = new Contato("Felipe", "Carvalho", "(83) 1111111111", "(83) 222222222", "(83) 333333333");
	
	/**
	 * Testa o construtor da classe Contato.
	 */
	@Test
	public void TestConstrutor() {
		Contato contato3 = new Contato("Rafael", "Silva", "(83) 9231239321", "(83) 38312393", "(83) 3213908129");
	}
	
	/**
	 * Testa o método getNome(), utilizado para obter o nome do contato em questão.
	 */
	@Test
	public void TestgetNome() {
		assertEquals("Gabriel", contato1.getNome());
	}
	
	/**
	 * Testa o método getSobrenome(), utilizado para obter o sobrenome do contato em questão.
	 */
	@Test 
	public void TestgetSobrenome() {
		assertEquals("Carvalho", contato1.getSobrenome());
	}
	
	/**
	 * Testa o método getPrioritario(), utilizado para obter o número prioritário do contato em questão.
	 */
	@Test
	public void TestgetPrioritario() {
		assertEquals("(83) 112233445", contato1.getPrioritario());
	}
	
	/**
	 * Testa o método getWhatsapp(), utilizado para obter o número whatsapp do contato em questão.
	 */
	@Test 
	public void TestgetWhatsapp() {
		assertEquals("(83) 544332211", contato1.getWhatsapp());
	}
	
	/**
	 * Testa o método getAdicional(), utilizado para obter o número adicional do contato em questão.
	 */
	@Test
	public void TestgetAdicional() {
		assertEquals("(83) 123456789", contato1.getAdicional());
	}
	
	/**
	 * Testa o método equalsContato(), utilizado para comparar dois contatos e informar se os dois são o mesmo contato ou não.
	 */
	@Test
	public void TestequalsContato() {
		assertFalse(contato1.equalsContato(contato2));
	}
	
}	
