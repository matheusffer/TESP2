package br.unibh;
import java.math.BigDecimal;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("João", "123431231233", 1234L, new Date());
		Aluno a2 = new Aluno("Maria", "3123134343", 1234L, new Date());
		Aluno a3 = new Aluno("Clodovaldo", "3131233", 1234L, new Date());
		
	
		Professor p1 = new Professor("Jose", "54531254545454", new BigDecimal(2344));
		Professor p2 = new Professor("Josefa", "54545321454", new BigDecimal(4230));
		
		System.out.println(Aluno.verificaMatricula("12345678"));
		System.out.println("chamando o BONUS professor "+Professor.BONUS);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a1);
		System.out.println(a2);		
		System.out.println(a3);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(p1);
		System.out.println(p2);
	}

}

