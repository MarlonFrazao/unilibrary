package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class LivroDAO extends DAO{
	private String SQL_INSERT = "INSERT INTO LIVROS (titulo, autorid, editoraid, descricao) values (?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE LIVROS SET titulo = ?, autorid = ?, editoraid = ?, descricao = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM LIVROS L INNER JOIN AUTORES A ON L.AUTORID = A.ID INNER JOIN EDITORAS E ON L.EDITORAID = E.ID ORDER BY L.TITULO;";
	private String SQL_OBTER_ID = "SELECT * FROM LIVROS L INNER JOIN AUTORES A ON L.AUTORID = A.ID INNER JOIN EDITORAS E ON L.EDITORAID = E.ID WHERE L.ID = ? ORDER BY L.TITULO;";
	private String SQL_OBTER_TITULO = "SELECT * FROM LIVROS L INNER JOIN AUTORES A ON L.AUTORID = A.ID INNER JOIN EDITORAS E ON L.EDITORAID = E.ID WHERE L.TITULO LIKE ? ORDER BY L.TITULO;";
	private String SQL_OBTER_AUTOR = "SELECT * FROM LIVROS L INNER JOIN AUTORES A ON L.AUTORID = A.ID INNER JOIN EDITORAS E ON L.EDITORAID = E.ID WHERE A.ID = ? ORDER BY L.TITULO";
	private String SQL_DELETE = "DELETE FROM LIVROS WHERE ID = ?;";
	
	public void inserir(Livro l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, l.getTitulo());
			ps.setInt(2, l.getAutor().getId());
			ps.setInt(3, l.getEditora().getId());
			ps.setString(4, l.getDescricao());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Livro l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, l.getTitulo());
			ps.setInt(2, l.getAutor().getId());
			ps.setInt(3, l.getEditora().getId());
			ps.setString(4, l.getDescricao());
			ps.setInt(5, l.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Livro> listar() {
		List<Livro> lista = new ArrayList<Livro>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livro l = new Livro(rs.getInt("l.id"), 
										rs.getString("l.titulo"),
										new Autor(rs.getInt("a.id"),
													rs.getString("a.nome"),
													rs.getInt("a.quanteditais")),
										new Editora(rs.getInt("e.id"),
														rs.getString("e.razaosocial"),
														rs.getString("e.endereco"),
														rs.getString("e.site"),
														rs.getString("e.email")),
										rs.getString("l.descricao"));
				lista.add(l);
			}
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Livro obter(int id) {
		Livro l = new Livro();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new Livro(rs.getInt("l.id"), 
						rs.getString("l.titulo"),
						new Autor(rs.getInt("a.id"),
									rs.getString("a.nome"),
									rs.getInt("a.quanteditais")),
						new Editora(rs.getInt("e.id"),
										rs.getString("e.razaosocial"),
										rs.getString("e.endereco"),
										rs.getString("e.site"),
										rs.getString("e.email")),
						rs.getString("l.descricao"));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public List<Livro> obter(String titulo) {
		List<Livro> lista = new ArrayList<Livro>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_TITULO);
			
			ps.setString(1, '%' + titulo + '%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livro l = new Livro(rs.getInt("l.id"), 
										rs.getString("l.titulo"),
										new Autor(rs.getInt("a.id"),
													rs.getString("a.nome"),
													rs.getInt("a.quanteditais")),
										new Editora(rs.getInt("e.id"),
														rs.getString("e.razaosocial"),
														rs.getString("e.endereco"),
														rs.getString("e.site"),
														rs.getString("e.email")),
										rs.getString("l.descricao"));
				lista.add(l);
			}
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Livro> obter(Autor a) {
		List<Livro> lista = new ArrayList<Livro>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_AUTOR);
			
			ps.setInt(1, a.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livro l = new Livro(rs.getInt("l.id"), 
										rs.getString("l.titulo"),
										new Autor(rs.getInt("a.id"),
													rs.getString("a.nome"),
													rs.getInt("a.quanteditais")),
										new Editora(rs.getInt("e.id"),
														rs.getString("e.razaosocial"),
														rs.getString("e.endereco"),
														rs.getString("e.site"),
														rs.getString("e.email")),
										rs.getString("l.descricao"));
				lista.add(l);
			}
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Livro l) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, l.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
