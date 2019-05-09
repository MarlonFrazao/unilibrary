package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;
import br.edu.unifacear.prjintegrador5.model.entity.LogAcesso;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

public class LogAcessoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO LOGACESSO (usuarioid, inicio, fim) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE LOGACESSO SET usuarioid = ?, inicio = ?, fim = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM LOGACESSO L INNER JOIN USUARIOS U ON L.usuarioid = U.id INNER JOIN ALUNOS A ON U.alunoid = A.id INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN CURSO C ON C.id = A.cursoid;";
	private String SQL_OBTER_ID = "SELECT * FROM LOGACESSO L INNER JOIN USUARIOS U ON L.usuarioid = U.id INNER JOIN ALUNOS A ON U.alunoid = A.id INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN CURSO C ON C.id = A.cursoid WHERE L.id = ?;";
	private String SQL_OBTER_USUARIO = "SELECT * FROM LOGACESSO L INNER JOIN USUARIOS U ON L.usuarioid = U.id INNER JOIN ALUNOS A ON U.alunoid = A.id INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN CURSO C ON C.id = A.cursoid WHERE U.id = ?;";
	private String SQL_DELETE = "DELETE FROM LOGACESSO WHERE id = ?;";
	
	public void inserir(LogAcesso l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1,  l.getUsuario().getId());
			ps.setDate(2, l.getInicio());
			ps.setDate(3, l.getFim());
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(LogAcesso l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1,  l.getUsuario().getId());
			ps.setDate(2, l.getInicio());
			ps.setDate(3, l.getFim());
			ps.setInt(4, l.getId());
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LogAcesso> listar() {
		List<LogAcesso> lista = new ArrayList<LogAcesso>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LogAcesso l = new LogAcesso(rs.getInt("L.id"), 
												new Usuario(rs.getInt("U.id"),
																rs.getInt("U.usuario"),
																rs.getInt("U.senha"),
																new Permissao(rs.getInt("P.id"),
																				rs.getString("P.descricao")),
																rs.getBoolean("U.status"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula"))),
												rs.getDate("L.inicio"),
												rs.getDate("L.fim"));
				lista.add(l);
			}
			
			desconectar();
			
			ps.close();
			
			rs.close();
		} catch(Exception e) {
			e.getStackTrace();
		}
		return lista;
	}
	
	public LogAcesso obter(int id) {
		LogAcesso l = new LogAcesso();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new LogAcesso(rs.getInt("L.id"), 
												new Usuario(rs.getInt("U.id"),
																rs.getInt("U.usuario"),
																rs.getInt("U.senha"),
																new Permissao(rs.getInt("P.id"),
																				rs.getString("P.descricao")),
																rs.getBoolean("U.status"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula"))),
												rs.getDate("L.inicio"),
												rs.getDate("L.fim"));
			}
			
			desconectar();
			
			ps.close();
			
			rs.close();
		} catch(Exception e) {
			e.getStackTrace();
		}
		return l;
	}
	
	public List<LogAcesso> obter(Usuario u) {
		List<LogAcesso> lista = new ArrayList<LogAcesso>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_USUARIO);
			
			ps.setInt(1, u.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LogAcesso l = new LogAcesso(rs.getInt("L.id"), 
												new Usuario(rs.getInt("U.id"),
																rs.getInt("U.usuario"),
																rs.getInt("U.senha"),
																new Permissao(rs.getInt("P.id"),
																				rs.getString("P.descricao")),
																rs.getBoolean("U.status"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula"))),
												rs.getDate("L.inicio"),
												rs.getDate("L.fim"));
				lista.add(l);
			}
			
			desconectar();
			
			ps.close();
			
			rs.close();
		} catch(Exception e) {
			e.getStackTrace();
		}
		return lista;
	}
	
	public void excluir(LogAcesso l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, l.getId());
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
