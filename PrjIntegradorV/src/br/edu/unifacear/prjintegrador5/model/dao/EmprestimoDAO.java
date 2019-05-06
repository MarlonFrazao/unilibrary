package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;
import br.edu.unifacear.prjintegrador5.model.entity.Emprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class EmprestimoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO EMPRESTIMOS (alunoid, livroid, datainicio, datafinal, status) VALUES (?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE EMPRESTIMOS SET alunoid = ?, livroid = ?, datainicio = ?, datafinal = ?, status = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM EMPRESTIMOS E INNER JOIN ALUNOS A ON E.ALUNOID = A.ID INNER JOIN LIVROS L ON E.LIVROID = L.ID INNER JOIN CURSOS C ON A.CURSOID = C.ID INNER JOIN EDITORAS ED ON L.EDITORAID = ED.ID INNER JOIN AUTORES AU ON L.AUTORID = AU.ID ORDER BY E.DATAINICIO;";
	private String SQL_OBTER_ID = "SELECT * FROM EMPRESTIMOS E INNER JOIN ALUNOS A ON E.ALUNOID = A.ID INNER JOIN LIVROS L ON E.LIVROID = L.ID INNER JOIN CURSOS C ON A.CURSOID = C.ID INNER JOIN EDITORAS ED ON L.EDITORAID = ED.ID INNER JOIN AUTORES AU ON L.AUTORID = AU.ID WHERE E.ID = ? ORDER BY E.DATAINICIO;";
	private String SQL_OBTER_ALUNO = "SELECT * FROM EMPRESTIMOS E INNER JOIN ALUNOS A ON E.ALUNOID = A.ID INNER JOIN LIVROS L ON E.LIVROID = L.ID INNER JOIN CURSOS C ON A.CURSOID = C.ID INNER JOIN EDITORAS ED ON L.EDITORAID = ED.ID INNER JOIN AUTORES AU ON L.AUTORID = AU.ID WHERE E.ALUNOID = ? ORDER BY E.DATAINICIO;";
	private String SQL_OBTER_LIVRO = "SELECT * FROM EMPRESTIMOS E INNER JOIN ALUNOS A ON E.ALUNOID = A.ID INNER JOIN LIVROS L ON E.LIVROID = L.ID INNER JOIN CURSOS C ON A.CURSOID = C.ID INNER JOIN EDITORAS ED ON L.EDITORAID = ED.ID INNER JOIN AUTORES AU ON L.AUTORID = AU.ID WHERE E.LIVROID = ? ORDER BY E.DATAINICIO;";
	private String SQL_DELETE = "DELETE FROM EMPRESTIMOS WHERE ID = ?;";
	
	public void inserir(Emprestimo e) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, e.getAluno().getId());
			ps.setInt(2, e.getLivro().getId());
			ps.setDate(3, e.getDataInicio());
			ps.setDate(4, e.getDataFinal());
			ps.setBoolean(5, e.getStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void alterar(Emprestimo e) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1, e.getAluno().getId());
			ps.setInt(2, e.getLivro().getId());
			ps.setDate(3, e.getDataInicio());
			ps.setDate(4, e.getDataFinal());
			ps.setBoolean(5, e.getStatus());
			ps.setInt(6, e.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Emprestimo> listar() {
		List<Emprestimo> lista = new ArrayList<Emprestimo>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Emprestimo e = new Emprestimo(rs.getInt("E.id"),
												new Aluno(rs.getInt("A.id"),
															rs.getString("A.nome"),
															rs.getString("A.email"),
															new Curso(rs.getInt("C.id"),
																		rs.getString("C.descricao"),
																		rs.getBoolean("C.status")),
															rs.getBoolean("A.status"),
															rs.getInt("A.matricula")),
												new Livro(rs.getInt("L.id"),
															rs.getString("L.titulo"),
															new Autor(rs.getInt("AU.id"),
																		rs.getString("AU.nome"),
																		rs.getInt("AU.quanteditais")),
															new Editora(rs.getInt("ED.id"),
																		rs.getString("ED.razaosocial"),
																		rs.getString("ED.endereco"),
																		rs.getString("ED.site"),
																		rs.getString("ED.site")),
															rs.getString("L.descricao")),
												rs.getDate("E.datainicio"),
												rs.getDate("E.datafinal"),
												rs.getBoolean("E.status"));
				lista.add(e);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
	public Emprestimo obter(int id) {
		Emprestimo e = new Emprestimo();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				e = new Emprestimo(rs.getInt("E.id"),
												new Aluno(rs.getInt("A.id"),
															rs.getString("A.nome"),
															rs.getString("A.email"),
															new Curso(rs.getInt("C.id"),
																		rs.getString("C.descricao"),
																		rs.getBoolean("C.status")),
															rs.getBoolean("A.status"),
															rs.getInt("A.matricula")),
												new Livro(rs.getInt("L.id"),
															rs.getString("L.titulo"),
															new Autor(rs.getInt("AU.id"),
																		rs.getString("AU.nome"),
																		rs.getInt("AU.quanteditais")),
															new Editora(rs.getInt("ED.id"),
																		rs.getString("ED.razaosocial"),
																		rs.getString("ED.endereco"),
																		rs.getString("ED.site"),
																		rs.getString("ED.site")),
															rs.getString("L.descricao")),
												rs.getDate("E.datainicio"),
												rs.getDate("E.datafinal"),
												rs.getBoolean("E.status"));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return e;
	}
	
	public List<Emprestimo> obter(Aluno a) {
		List<Emprestimo> lista = new ArrayList<Emprestimo>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ALUNO);
			
			ps.setInt(1, a.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Emprestimo e = new Emprestimo(rs.getInt("E.id"),
												new Aluno(rs.getInt("A.id"),
															rs.getString("A.nome"),
															rs.getString("A.email"),
															new Curso(rs.getInt("C.id"),
																		rs.getString("C.descricao"),
																		rs.getBoolean("C.status")),
															rs.getBoolean("A.status"),
															rs.getInt("A.matricula")),
												new Livro(rs.getInt("L.id"),
															rs.getString("L.titulo"),
															new Autor(rs.getInt("AU.id"),
																		rs.getString("AU.nome"),
																		rs.getInt("AU.quanteditais")),
															new Editora(rs.getInt("ED.id"),
																		rs.getString("ED.razaosocial"),
																		rs.getString("ED.endereco"),
																		rs.getString("ED.site"),
																		rs.getString("ED.site")),
															rs.getString("L.descricao")),
												rs.getDate("E.datainicio"),
												rs.getDate("E.datafinal"),
												rs.getBoolean("E.status"));
				lista.add(e);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Emprestimo> obter(Livro l) {
		List<Emprestimo> lista = new ArrayList<Emprestimo>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_LIVRO);
			
			ps.setInt(1, l.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Emprestimo e = new Emprestimo(rs.getInt("E.id"),
												new Aluno(rs.getInt("A.id"),
															rs.getString("A.nome"),
															rs.getString("A.email"),
															new Curso(rs.getInt("C.id"),
																		rs.getString("C.descricao"),
																		rs.getBoolean("C.status")),
															rs.getBoolean("A.status"),
															rs.getInt("A.matricula")),
												new Livro(rs.getInt("L.id"),
															rs.getString("L.titulo"),
															new Autor(rs.getInt("AU.id"),
																		rs.getString("AU.nome"),
																		rs.getInt("AU.quanteditais")),
															new Editora(rs.getInt("ED.id"),
																		rs.getString("ED.razaosocial"),
																		rs.getString("ED.endereco"),
																		rs.getString("ED.site"),
																		rs.getString("ED.site")),
															rs.getString("L.descricao")),
												rs.getDate("E.datainicio"),
												rs.getDate("E.datafinal"),
												rs.getBoolean("E.status"));
				lista.add(e);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(Emprestimo e) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, e.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			
		}
	}
}
