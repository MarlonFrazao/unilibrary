package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Curso;

public class CursoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO CURSOS (descricao, status) values (?, ?);";
	private String SQL_UPDATE = "UPDATE CURSOS SET descricao = ?, status = ? where id = ?;";
	private String SQL_SELECT = "SELECT * FROM CURSOS;";
	private String SQL_OBTER_ID = "SELECT * FROM CURSOS WHERE id = ?;";
	private String SQL_OBTER_DESCRICAO = "SELECT * FROM CURSOS WHERE descricao like ?;";
	private String SQL_DELETE = "DELETE FROM CURSOS WHERE id = ?;";
	
	public void inserir(Curso c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getDescricao());
			ps.setBoolean(2, c.getStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Curso c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, c.getDescricao());
			ps.setBoolean(2, c.getStatus());
			ps.setInt(3, c.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Curso> listar() {
		List<Curso> lista = new ArrayList<Curso>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Curso c = new Curso(rs.getInt("id"),
										rs.getString("descricao"),
										rs.getBoolean("status"));
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Curso obter(int id) {
		Curso c = new Curso();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Curso(rs.getInt("id"),
										rs.getString("descricao"),
										rs.getBoolean("status"));
				}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<Curso> obter(String descricao) {
		List<Curso> lista = new ArrayList<Curso>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DESCRICAO);
			
			ResultSet rs = ps.executeQuery();
			
			ps.setString(1, descricao);
			
			while(rs.next()) {
				Curso c = new Curso(rs.getInt("id"),
										rs.getString("descricao"),
										rs.getBoolean("status"));
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(Curso c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, c.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
