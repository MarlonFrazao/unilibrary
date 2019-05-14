package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class FilaDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO FILA(livroid, status) values(?, ?);";
	private String SQL_UPDATE = "UPDATE FILA SET livroid = ?, status = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM FILA F INNER JOIN LIVRO L ON F.livroid = L.id INNER JOIN AUTOR A ON L.autorid = A.id INNER JOIN EDITORA E ON L.editora id = E.id;";
	private String SQL_OBTER_ID = "SELECT * FROM FILA F INNER JOIN LIVRO L ON F.livroid = L.id INNER JOIN AUTOR A ON L.autorid = A.id INNER JOIN EDITORA E ON L.editora id = E.id WHERE F.id = ?;";
	private String SQL_OBTER_LIVRO = "SELECT * FROM FILA F INNER JOIN LIVRO L ON F.livroid = L.id INNER JOIN AUTOR A ON L.autorid = A.id INNER JOIN EDITORA E ON L.editora id = E.id WHERE L.id = ?;";
	private String SQL_DELETE = "DELETE FROM FILA WHERE id = ?;";
	
	public void inserir(Fila f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, f.getLivro().getId());
			ps.setBoolean(2, f.getStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Fila f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1, f.getLivro().getId());
			ps.setBoolean(2, f.getStatus());
			ps.setInt(3, f.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Fila> listar() {
		List<Fila> lista = new ArrayList<Fila>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Fila f = new Fila(rs.getInt("F.id"),
									new Livro(rs.getInt("L.id"),
											rs.getString("L.titulo"),
											new Autor(rs.getInt("A.id"),
														rs.getString("A.nome"),
														rs.getInt("A.quanteditais")),
											new Editora(rs.getInt("E.id"),
															rs.getString("E.razaosocial"),
															rs.getString("E.endereco"),
															rs.getString("E.site"),
															rs.getString("E.email")),
											rs.getString("L.descricao")),
									rs.getBoolean("F.status"));
				lista.add(f);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Fila obter(int id) {
		Fila f = new Fila();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Fila(rs.getInt("F.id"), 
								new Livro(rs.getInt("L.id"), 
											rs.getString("L.titulo"),
											new Autor(rs.getInt("A.id"), 
														rs.getString("A.nome"), 
														rs.getInt("A.quanteditais")),
											new Editora(rs.getInt("E.id"), 
															rs.getString("E.razaosocial"), 
															rs.getString("E.endereco"),
															rs.getString("E.site"), 
															rs.getString("E.email")),
											rs.getString("L.descricao")), 
								rs.getBoolean("F.status"));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Fila> obter(Livro l) {
		List<Fila> lista = new ArrayList<Fila>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_LIVRO);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Fila f = new Fila(rs.getInt("F.id"),
									new Livro(rs.getInt("L.id"),
											rs.getString("L.titulo"),
											new Autor(rs.getInt("A.id"),
														rs.getString("A.nome"),
														rs.getInt("A.quanteditais")),
											new Editora(rs.getInt("E.id"),
															rs.getString("E.razaosocial"),
															rs.getString("E.endereco"),
															rs.getString("E.site"),
															rs.getString("E.email")),
											rs.getString("L.descricao")),
									rs.getBoolean("F.status"));
				lista.add(f);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(Fila f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, f.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
