package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Autor;

public class AutorDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO AUTORES (nome, quanteditais) values (?, ?);";
	private String SQL_UPDATE = "UPDATE AUTORES SET nome = ?, quanteditais = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM AUTORES;";
	private String SQL_OBTER_ID = "SELECT * FROM AUTORES WHERE id = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM AUTORES WHERE nome like ? order by nome;";
	private String SQL_DELETE = "DELETE FROM AUTORES WHERE id = ?;";
	
	public void inserir(Autor a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getQuantEditais());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Autor a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getQuantEditais());
			ps.setInt(3, a.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Autor> listar() {
		List<Autor> lista = new ArrayList<Autor>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Autor a = new Autor(rs.getInt("id"),
										rs.getString("nome"),
										rs.getInt("quanteditais"));
				lista.add(a);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Autor obter(int id) {
		Autor a = new Autor();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new Autor(rs.getInt("id"),
								rs.getString("nome"),
								rs.getInt("quanteditais"));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Autor> obter(String nome) {
		List<Autor> lista = new ArrayList<Autor>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Autor a = new Autor(rs.getInt("id"),
										rs.getString("nome"),
										rs.getInt("quanteditais"));
				lista.add(a);
			}
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Autor a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, a.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
