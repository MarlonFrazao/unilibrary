package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

public class AlunoDAO extends DAO{
	private String SQL_INSERT = "INSERT INTO ALUNOS (nome, email, cursoid, status, matricula) values (?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE ALUNOS SET nome = ?, email = ?, cursoid = ?, status = ?, matricula = ? where id = ?;";
	private String SQL_SELECT = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id ORDER BY A.nome;";
	private String SQL_OBTER_ID = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id WHERE A.id = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id WHERE A.nome like ? ORDER BY A.nome;";
	private String SQL_OBTER_EMAIL = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id WHERE A.email = ?;";
	private String SQL_OBTER_MATRICULA = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id WHERE A.matricula = ?;";
	private String SQL_OBTER_CURSO = "SELECT * FROM ALUNOS A INNER JOIN CURSOS C ON A.cursoid = C.id WHERE A.cursoid = ? ORDER BY A.nome;";
	private String SQL_DELETE = "DELETE FROM ALUNOS WHERE id = ?;";
	
	public void inserir(Aluno a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, a.getNome());
			ps.setString(2, a.getEmail());
			ps.setInt(3, a.getCurso().getId());
			ps.setBoolean(4, a.getStatus());
			ps.setInt(5, a.getMatricula());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Aluno a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, a.getNome());
			ps.setString(2, a.getEmail());
			ps.setInt(3, a.getCurso().getId());
			ps.setBoolean(4, a.getStatus());
			ps.setInt(5, a.getMatricula());
			ps.setInt(6, a.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aluno a = new Aluno(rs.getInt("A.id"),
										rs.getString("A.nome"),
										rs.getString("A.email"),
										new Curso(rs.getInt("C.id"),
													rs.getString("C.descricao"),
													rs.getBoolean("C.status")),
										rs.getBoolean("A.status"),
										rs.getInt("A.marticula"));
				lista.add(a);
			}
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

  public Aluno obterPorId(int id) {
     Aluno a = new Aluno();
     try {
          conectar();
        
          PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
          ps.setInt(1, id);

          ResultSet rs = ps.executeQuery();

          while(rs.next()) {
                a = new Aluno(rs.getInt("A.id"),
										rs.getString("A.nome"),
										rs.getString("A.email"),
										new Curso(rs.getInt("C.id"),
													rs.getString("C.descricao"),
													rs.getBoolean("C.status")),
										rs.getBoolean("A.status"),
										rs.getInt("A.marticula"));
           }

          desconectar();

          ps.close();
     } catch(Exception e) {
          e.printStackTrace();
     }
     return a;
  }

  public List<Aluno> obterPorNome(String nome) {
     List<Aluno> lista = new ArrayList<Aluno>();
     
     try {
          conectar();
          
          PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
   
           ps.setString(1, '%' + nome + '%');

           ResultSet rs = ps.executeQuery();

          while(rs.next()) {
                Aluno a = new Aluno(rs.getInt("A.id"),
										rs.getString("A.nome"),
										rs.getString("A.email"),
										new Curso(rs.getInt("C.id"),
													rs.getString("C.descricao"),
													rs.getBoolean("C.status")),
										rs.getBoolean("A.status"),
										rs.getInt("A.marticula"));
           lista.add(a);
           }
           
          desconectar();

          ps.close();
     } catch(Exception e) {
          e.printStackTrace();
     }
     return lista;
  }
}
