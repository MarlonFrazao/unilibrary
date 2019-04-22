package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Usuario;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

public class UsuarioDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO USUARIOS (usuario, senha, permissaoid, status, alunoid) values (?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE USUARIOS SET usuario = ?, senha = ?, permissaoid = ?, status = ?, alunoid = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id INNER JOIN cursos C on A.cursoid = C.id;";
	private String SQL_OBTER_ID = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id INNER JOIN cursos C on A.cursoid = C.id WHERE U.id = ?;";
	private String SQL_OBTER_USUARIO = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id INNER JOIN cursos C on A.cursoid = C.id WHERE U.usuario = ?;";
	private String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID = ?;";
	
	public void inserir(Usuario u) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, u.getUsuario());
			ps.setInt(2, u.getSenha());
			ps.setInt(3, u.getPermissao().getId());
			ps.setBoolean(4, u.getStatus());
			ps.setInt(5, u.getAluno().getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario u) {
		try{
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1, u.getUsuario());
			ps.setInt(2, u.getSenha());
			ps.setInt(3, u.getPermissao().getId());
			ps.setBoolean(4, u.getStatus());
			ps.setInt(5, u.getAluno().getId());
			ps.setInt(6, u.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario(rs.getInt("U.id"),
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
														rs.getInt("A.matricula")));
				lista.add(u);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario obterPorId(int id) {
		Usuario u = new Usuario();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Usuario(rs.getInt("U.id"),
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
												rs.getInt("A.matricula")));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Usuario obterPorUsuario(int usuario) {
		Usuario u = new Usuario();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_USUARIO);
			
			ps.setInt(1, usuario);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Usuario(rs.getInt("U.id"),
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
												rs.getInt("A.matricula")));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public void excluir(Usuario u) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, u.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
