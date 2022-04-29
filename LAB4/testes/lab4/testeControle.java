package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeControle {

	private Controle controle;

	@BeforeEach
	void initControle() {
		this.controle = new Controle();
		controle.cadastraAluno("250", "Gabriel Reyes", "Computa��o");
		controle.cadastraAluno("200", "Lili Camposh", "Computa��o");
		controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		controle.cadastraGrupo("Programa��o OO",  "");
		controle.cadastraGrupo("Listas", "Computa��o");
	}
	
	@Test
	public void CadastrarGrupoNomeExistente() {
		controle.cadastraGrupo("Listas", "Computa��o");
		assertEquals("GRUPO J� CADASTRADO!", controle.cadastraGrupo("Listas", ""));
	}
	
	@Test
	public void AlocarAluno() {
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("200","Programa��o OO"));
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("202", "Programa��o OO"));
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("200", "Programa��o OO"));
	}
	
	@Test
	public void AlocarAlunoOuGrupoNaoExistentes() {
		assertEquals("Aluno n�o cadastrado", controle.alocaAluno("100", "Programa��o OO"));
		assertEquals("Grupo n�o cadastrado.", controle.alocaAluno("200", "Anatomia"));
	}
	
	@Test
	public void AlocarAlunoComRestricao() {
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("250", "Listas"));
	}
	
	@Test
	public void PertinenciaAGrupo() {
		controle.alocaAluno("250", "Listas");
		assertEquals("ALUNO PERTENCE AO GRUPO", controle.pertinenciaGrupo("Listas", "250"));
		assertEquals("ALUNO N�O PERTENCE AO GRUPO", controle.pertinenciaGrupo("Listas", "202"));
	}
	
	@Test
	public void PertinenciaGrupoOuAlunoNaoCadastrado() {
		assertEquals("ALUNO N�O PERTENCE AO GRUPO", controle.pertinenciaGrupo("Programa��o OO", "100"));
		assertEquals("ALUNO N�O PERTENCE AO GRUPO", controle.pertinenciaGrupo("Anatomia", "200"));
	}
	
	@Test
	public void ContagensDeRestricao() {
		assertEquals("Computa��o 1", controle.ImprimeRestricoes("Computa��o"));
		assertEquals("Medicina 0", controle.ImprimeRestricoes("Medicina"));
		assertEquals("Engenharia Mec�nica 0", controle.ImprimeRestricoes("Engenharia Mec�nica"));
	}
	
	@Test
	public void CadastrarRespostaAlunoNaoCadastrado() {
		assertEquals("Aluno n�o cadastrado.", controle.cadastraRespostas("100"));
	}
	
	@Test
	public void CadastrarResposta() {
		assertEquals("ALUNO REGISTRADO!", controle.cadastraRespostas("250"));
	}
	
	@Test 
	public void ImprimirRespostas() {
		controle.cadastraRespostas("250");
		assertEquals("Alunos: \n1: 250 - Gabriel Reyes - Computa��o", controle.ImprimeAlunosRespostas());
	}
	
	@Test
	public void ExibeAlunoNaoCadastrado() {
		assertEquals("Aluno n�o cadastrado.", controle.exibeAluno("100"));
	}
	
	@Test
	public void ExibeAlunoCadastrado() {
		assertEquals("Aluno: 250 - Gabriel Reyes - Computa��o", controle.exibeAluno("250"));
	}
	
	@Test
	public void CadastrarMatriculaJaCadastrada() {
		assertEquals("MATR�CULA J� CADASTRADA!", controle.cadastraAluno("250", "Gabriel Reyes", "Computa��o"));
	}
	
	@Test
	public void AlocarAlunoDeOutroCurso() {
		assertEquals("GRUPO COM RESTRI��O DE CURSO", controle.alocaAluno("202", "Listas"));
	}
}