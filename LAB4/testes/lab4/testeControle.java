package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeControle {

	private Controle controle;

	@BeforeEach
	void initControle() {
		this.controle = new Controle();
		controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		controle.cadastraAluno("200", "Lili Camposh", "Computação");
		controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		controle.cadastraGrupo("Programação OO",  "");
		controle.cadastraGrupo("Listas", "Computação");
	}
	
	@Test
	public void CadastrarGrupoNomeExistente() {
		controle.cadastraGrupo("Listas", "Computação");
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastraGrupo("Listas", ""));
	}
	
	@Test
	public void AlocarAluno() {
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("200","Programação OO"));
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("202", "Programação OO"));
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("200", "Programação OO"));
	}
	
	@Test
	public void AlocarAlunoOuGrupoNaoExistentes() {
		assertEquals("Aluno não cadastrado", controle.alocaAluno("100", "Programação OO"));
		assertEquals("Grupo não cadastrado.", controle.alocaAluno("200", "Anatomia"));
	}
	
	@Test
	public void AlocarAlunoComRestricao() {
		assertEquals("ALUNO ALOCADO", controle.alocaAluno("250", "Listas"));
	}
	
	@Test
	public void PertinenciaAGrupo() {
		controle.alocaAluno("250", "Listas");
		assertEquals("ALUNO PERTENCE AO GRUPO", controle.pertinenciaGrupo("Listas", "250"));
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", controle.pertinenciaGrupo("Listas", "202"));
	}
	
	@Test
	public void PertinenciaGrupoOuAlunoNaoCadastrado() {
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", controle.pertinenciaGrupo("Programação OO", "100"));
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", controle.pertinenciaGrupo("Anatomia", "200"));
	}
	
	@Test
	public void ContagensDeRestricao() {
		assertEquals("Computação 1", controle.ImprimeRestricoes("Computação"));
		assertEquals("Medicina 0", controle.ImprimeRestricoes("Medicina"));
		assertEquals("Engenharia Mecânica 0", controle.ImprimeRestricoes("Engenharia Mecânica"));
	}
	
	@Test
	public void CadastrarRespostaAlunoNaoCadastrado() {
		assertEquals("Aluno não cadastrado.", controle.cadastraRespostas("100"));
	}
	
	@Test
	public void CadastrarResposta() {
		assertEquals("ALUNO REGISTRADO!", controle.cadastraRespostas("250"));
	}
	
	@Test 
	public void ImprimirRespostas() {
		controle.cadastraRespostas("250");
		assertEquals("Alunos: \n1: 250 - Gabriel Reyes - Computação", controle.ImprimeAlunosRespostas());
	}
	
	@Test
	public void ExibeAlunoNaoCadastrado() {
		assertEquals("Aluno não cadastrado.", controle.exibeAluno("100"));
	}
	
	@Test
	public void ExibeAlunoCadastrado() {
		assertEquals("Aluno: 250 - Gabriel Reyes - Computação", controle.exibeAluno("250"));
	}
	
	@Test
	public void CadastrarMatriculaJaCadastrada() {
		assertEquals("MATRÍCULA JÁ CADASTRADA!", controle.cadastraAluno("250", "Gabriel Reyes", "Computação"));
	}
	
	@Test
	public void AlocarAlunoDeOutroCurso() {
		assertEquals("GRUPO COM RESTRIÇÃO DE CURSO", controle.alocaAluno("202", "Listas"));
	}
}