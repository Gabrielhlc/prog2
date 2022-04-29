package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Clase que testa as funcionalidades da classe Grupo.
 * @author Gabriel
 *
 */
class testeGrupo {
	
	@Test
	void testConstrutor() {
		Grupo grupo = new Grupo("Listas", "Computa��o");
		assertEquals("Listas", grupo.getNome());
		assertEquals("Computa��o", grupo.getRestricao());
	}

}