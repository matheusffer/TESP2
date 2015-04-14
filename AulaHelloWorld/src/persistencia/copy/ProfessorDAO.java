package persistencia.copy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entidades.Professor;
import entidades.Professor;


public class ProfessorDAO implements DAO <Professor, String> {

	public Professor find(String cpf) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("Select * from db_professor where id = 1");
			p.setString(1,cpf);
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Professor(r.getLong("id"),
						r.getString("nome"),
						r.getString("cpf"),						
						r.getBigDecimal("salario"));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Professor Insert(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("Insert into tb_professor (matricula, nome, " + 
							"cpf, data_aniversario) values (?, ?, ?, ?)");


			p.setLong(1, t.getId());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			p.setBigDecimal(4, t.getSalario());
			
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Professor(r.getLong("id"),
						r.getString("nome"),
						r.getString("cpf"),						
						r.getBigDecimal("salario"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Professor t) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("Update into tb_professor set matricula = ?,"+" nome = ?,"+
							"cpf = ?,"+ "data_aniversario = ?"+
							"where id = ?");

			
					
			p.setLong(1, t.getId());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			p.setBigDecimal(4, t.getSalario());

			ResultSet r = p.executeQuery();
			p.setLong(1, t.getId());
			p.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public void delete(Professor t) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("delete from tb_professor where id = ?"+
							"where id = ?");


			p.setLong(1,t.getId());
			p.executeUpdate();

			
			ResultSet r = p.executeQuery();
			p.setLong(1, t.getId());
			p.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}


	@Override
	public List<Professor> findit() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Professor find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(Professor t) {
		// TODO Auto-generated method stub

	}

}