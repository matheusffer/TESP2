package br.unibh;
import java.util.Date;

import org.junit.Test;

import entidades.Aluno;
import junit.framework.Assert;
import persistencia.AlunoDAO;
import persistencia.DAO;

public class Teste {

	@Test

	public void testeAlunoFind(){
		
		AlunoDAO dao = new AlunoDAO ();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "123456789");
		
;
		}
	@Test
	public void testeAlunoInsert(){
		
		AlunoDAO dao = new AlunoDAO ();
		Aluno a = new Aluno(null, "123456789", "João", 15423L, new Date());
		dao.insert(a);
		
		
		Assert.assertEquals(a.getCpf(), "123456789");
		
;
		}
}

