package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.AgendarEmprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class AgendarEmprestimoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO AGENDAREMPRESTIMO (alunoid, status, posicaofilaid) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE AGENDAREMPRESTIMO SET alunoid = ?, status = ?, posicaofilaid = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM AGENDAREMPRESTIMO AE INNER JOIN ALUNOS A ON AE.alunoid = A.id INNER JOIN CURSOS C ON A.cursoid = C.id INNER JOIN FILA F ON AE.posicaofilaid = F.id INNER JOIN LIVROS L ON F.livroid = L.id INNER JOIN AUTORES AU ON L.autorid = AU.id INNER JOIN EDITORAS E ON L.editoraid = E.id;";
	private String SQL_OBTER_ID = "SELECT * FROM AGENDAREMPRESTIMO AE INNER JOIN ALUNOS A ON AE.alunoid = A.id INNER JOIN CURSOS C ON A.cursoid = C.id INNER JOIN FILA F ON AE.posicaofilaid = F.id INNER JOIN LIVROS L ON F.livroid = L.id INNER JOIN AUTORES AU ON L.autorid = AU.id INNER JOIN EDITORAS E ON L.editoraid = E.id WHERE AE.id = ?;";
	private String SQL_OBTER_ALUNO = "SELECT * FROM AGENDAREMPRESTIMO AE INNER JOIN ALUNOS A ON AE.alunoid = A.id INNER JOIN CURSOS C ON A.cursoid = C.id INNER JOIN FILA F ON AE.posicaofilaid = F.id INNER JOIN LIVROS L ON F.livroid = L.id INNER JOIN AUTORES AU ON L.autorid = AU.id INNER JOIN EDITORAS E ON L.editoraid = E.id WHERE A.id = ?;";
	private String SQL_OBTER_FILA = "SELECT * FROM AGENDAREMPRESTIMO AE INNER JOIN ALUNOS A ON AE.alunoid = A.id INNER JOIN CURSOS C ON A.cursoid = C.id INNER JOIN FILA F ON AE.posicaofilaid = F.id INNER JOIN LIVROS L ON F.livroid = L.id INNER JOIN AUTORES AU ON L.autorid = AU.id INNER JOIN EDITORAS E ON L.editoraid = E.id WHERE F.id = ?;";
	private String SQL_DELETE = "DELETE FROM AGENDAREMPRESTIMO WHERE id = ?;";
	
	public void inserir(AgendarEmprestimo a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, a.getAluno().getId());
			ps.setBoolean(2, a.getStatus());
			ps.setInt(3, a.getFila().getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(AgendarEmprestimo a) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1, a.getAluno().getId());
			ps.setBoolean(2, a.getStatus());
			ps.setInt(3, a.getFila().getId());
			ps.setInt(4, a.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<AgendarEmprestimo> listar() {
		List<AgendarEmprestimo> lista = new ArrayList<AgendarEmprestimo>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AgendarEmprestimo a = new AgendarEmprestimo(rs.getInt("AE.id"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula")),
																rs.getBoolean("AE.status"),
																new Fila(rs.getInt("F.id"),
																			new Livro(rs.getInt("L.id"),
																						rs.getString("L.titulo"),
																						new Autor(rs.getInt("AU.id"),
																									rs.getString("AU.nome"),
																									rs.getInt("AU.quanteditais")),
																						new Editora(rs.getInt("E.id"),
																										rs.getString("E.razaosocial"),
																										rs.getString("E.endereco"),
																										rs.getString("E.site"),
																										rs.getString("E.email")),
																						rs.getString("L.descricao")),
																			rs.getBoolean("F.status")));
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
	
	public AgendarEmprestimo obter(int id) {
		AgendarEmprestimo a = new AgendarEmprestimo();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new AgendarEmprestimo(rs.getInt("AE.id"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula")),
																rs.getBoolean("AE.status"),
																new Fila(rs.getInt("F.id"),
																			new Livro(rs.getInt("L.id"),
																						rs.getString("L.titulo"),
																						new Autor(rs.getInt("AU.id"),
																									rs.getString("AU.nome"),
																									rs.getInt("AU.quanteditais")),
																						new Editora(rs.getInt("E.id"),
																										rs.getString("E.razaosocial"),
																										rs.getString("E.endereco"),
																										rs.getString("E.site"),
																										rs.getString("E.email")),
																						rs.getString("L.descricao")),
																			rs.getBoolean("F.status")));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<AgendarEmprestimo> obter(Aluno aluno) {
		List<AgendarEmprestimo> lista = new ArrayList<AgendarEmprestimo>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ALUNO);
			
			ps.setInt(1, aluno.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AgendarEmprestimo a = new AgendarEmprestimo(rs.getInt("AE.id"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula")),
																rs.getBoolean("AE.status"),
																new Fila(rs.getInt("F.id"),
																			new Livro(rs.getInt("L.id"),
																						rs.getString("L.titulo"),
																						new Autor(rs.getInt("AU.id"),
																									rs.getString("AU.nome"),
																									rs.getInt("AU.quanteditais")),
																						new Editora(rs.getInt("E.id"),
																										rs.getString("E.razaosocial"),
																										rs.getString("E.endereco"),
																										rs.getString("E.site"),
																										rs.getString("E.email")),
																						rs.getString("L.descricao")),
																			rs.getBoolean("F.status")));
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
	
	public AgendarEmprestimo obter(Fila f) {
		AgendarEmprestimo a = new AgendarEmprestimo();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_FILA);
			
			ps.setInt(1, f.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new AgendarEmprestimo(rs.getInt("AE.id"),
																new Aluno(rs.getInt("A.id"),
																			rs.getString("A.nome"),
																			rs.getString("A.email"),
																			new Curso(rs.getInt("C.id"),
																						rs.getString("C.descricao"),
																						rs.getBoolean("C.status")),
																			rs.getBoolean("A.status"),
																			rs.getInt("A.matricula")),
																rs.getBoolean("AE.status"),
																new Fila(rs.getInt("F.id"),
																			new Livro(rs.getInt("L.id"),
																						rs.getString("L.titulo"),
																						new Autor(rs.getInt("AU.id"),
																									rs.getString("AU.nome"),
																									rs.getInt("AU.quanteditais")),
																						new Editora(rs.getInt("E.id"),
																										rs.getString("E.razaosocial"),
																										rs.getString("E.endereco"),
																										rs.getString("E.site"),
																										rs.getString("E.email")),
																						rs.getString("L.descricao")),
																			rs.getBoolean("F.status")));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public void excluir(AgendarEmprestimo a) {
		try{
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
