package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeAluno {

	@Test
	public void testConstrutor() {
		Aluno aluno = new Aluno("250", "Gabriel Carvalho", "Computação");
		assertEquals("250", aluno.getMatricula());
		assertEquals("Gabriel Carvalho", aluno.getNome());
		assertEquals("Computação", aluno.getCurso());
	}
	
	@Test
	public void testtoString() {
		Aluno aluno = new Aluno("250", "Gabriel Carvalho", "Computação");
		assertEquals("250 - Gabriel Carvalho - Computação", aluno.toString());
	}
}