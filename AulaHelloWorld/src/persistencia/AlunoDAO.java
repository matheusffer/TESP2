package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entidades.Aluno;

public class AlunoDAO implements DAO <Aluno,Long>{
	
private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Aluno find(Long id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("Select * from db_aluno where id = 1");
			p.setLong(1,id);
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Aluno(r.getLong("id"),
						r.getString("cpf"),
						r.getString("nome"),
						r.getLong("matricula"),
						df.parse(r.getString("data_aniversario")));
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
	public Aluno Insert(Aluno t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().
					prepareStatement("Insert into tb_aluno (matricula, nome, " + 
								"cpf, data_aniversario) values (?, ?, ?, ?)");
			
			
			p.setLong(1,t.getMatricula());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			if (t.getDataAniversario()==null){
				p.setNull(4, Types.NULL);}
			else{
				p.setString(4, df.format(t.getDataAniversario()));
			}
			
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Aluno(r.getLong("id"),
						r.getString("cpf"),
						r.getString("nome"),
						r.getLong("matricula"),
						df.parse(r.getString("data_aniversario")));
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
	public void insert(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> findit() {
		// TODO Auto-generated method stub
		return null;
	}

}
