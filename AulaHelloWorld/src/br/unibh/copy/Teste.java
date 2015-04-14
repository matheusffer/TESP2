package br.unibh.copy;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import entidades.Aluno;
import junit.framework.Assert;
import persistencia.AlunoDAO;
import persistencia.JDBCUtil;

@SuppressWarnings("deprecation")
public class Teste {
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
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
	public void testeAlunoUpdate(){
		
		AlunoDAO dao = new AlunoDAO ();
		Aluno a = dao.find("123456789");
		a.setNome("Joseph");
		dao.update(a);
		
		
		Assert.assertEquals(a.getCpf(), "123456789");
}
	public List<Aluno> findall(){
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		try{
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("select * from tb_aluno");

			ResultSet r = p.executeQuery();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return lista;
		}
		
	@Test
public void testeAlunoDelete(){
		
		AlunoDAO dao = new AlunoDAO ();
		Aluno a = dao.find("123456789");
		a.setNome("Joseph");
		dao.delete(a);
}
	}

