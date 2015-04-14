package br.unibh.copy;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import persistencia.JDBCUtil;
import entidades.Aluno;
import entidades.Professor;

public class HelloWorld {

	public static void main(String[] args) {

		Aluno a1 = new Aluno(1L, "João", "123431231233", 1234L, new Date());
		Aluno a2 = new Aluno(2L, "Maria", "3123134343", 1234L, new Date());
		Aluno a3 = new Aluno(3L, "Clodovaldo", "3131233", 1234L, new Date());

		Professor p1 = new Professor(3L, "Jose", "54531254545454", new BigDecimal(
				2344));
		Professor p2 = new Professor(5L, "Josefa", "54545321454", new BigDecimal(
				4230));

		
		System.out.println(Aluno.verificaMatricula("12345678"));
		System.out.println("chamando o BONUS professor " + Professor.BONUS);

		System.out.println("");
		System.out.println("");

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

		System.out.println("");
		System.out.println("");

		System.out.println(p1);
		System.out.println(p2);
		
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement("select * from tb_aluno").executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
