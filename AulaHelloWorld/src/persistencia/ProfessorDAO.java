package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

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
					prepareStatement("Insert into tb_professor (nome, " + 
								"cpf, salario) values (?, ?, ?, ?)");
			
			
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Professor(r.getLong("id"),
						r.getString("cpf"),
						r.getString("nome"),
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
	public void insert(Professor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Professor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Professor t) {
		// TODO Auto-generated method stub
		
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

}
