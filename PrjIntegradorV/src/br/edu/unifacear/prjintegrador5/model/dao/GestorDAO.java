package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;
import br.edu.unifacear.prjintegrador5.model.entity.Gestor;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;

public class GestorDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO GESTORES (usuario, senha, permissaoid, status, funcionarioid) values (?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE GESTORES SET usuario = ?, senha = ?, permissaoid = ?, status = ?, funcionarioid = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM GESTORES G INNER JOIN PERMISSOES P ON G.permissaoid = P.id INNER JOIN FUNCIONARIOS F ON G.funcionarioid = F.id;";
	private String SQL_OBTER_ID = "SELECT * FROM GESTORES G INNER JOIN PERMISSOES P ON G.permissaoid = P.id INNER JOIN FUNCIONARIOS F ON G.funcionarioid = F.id WHERE G.id = ?;";
	private String SQL_OBTER_USUARIO = "SELECT * FROM GESTORES G INNER JOIN PERMISSOES P ON G.permissaoid = P.id INNER JOIN FUNCIONARIOS F ON G.funcionarioid = F.id WHERE G.usuario = ?;";
	private String SQL_OBTER_FUNCIONARIO = "SELECT * FROM GESTORES G INNER JOIN PERMISSOES P ON G.permissaoid = P.id INNER JOIN FUNCIONARIOS F ON G.funcionarioid = F.id WHERE F.id = ?;";
	private String SQL_DELETE = "DELETE FROM GESTORES WHERE ID = ?;";	
	
	public void inserir(Gestor g) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setInt(1, g.getUsuario());
			ps.setInt(2, g.getSenha());
			ps.setInt(3, g.getPermissao().getId());
			ps.setBoolean(4, g.getStatus());
			ps.setInt(5, g.getFuncionario().getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Gestor g) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setInt(1, g.getUsuario());
			ps.setInt(2, g.getSenha());
			ps.setInt(3, g.getPermissao().getId());
			ps.setBoolean(4, g.getStatus());
			ps.setInt(5, g.getFuncionario().getId());
			ps.setInt(6, g.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Gestor> listar() {
		List<Gestor> lista = new ArrayList<Gestor>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Gestor g = new Gestor(rs.getInt("G.id"),
										rs.getInt("G.usuario"),
										rs.getInt("G.senha"),
										new Permissao(rs.getInt("P.id"),
														rs.getString("P.descricao")),
										rs.getBoolean("G.status"),
										new Funcionario(rs.getInt("F.id"),
														rs.getString("F.nome"),
														rs.getString("F.email"),
														rs.getInt("F.contrato"),
														rs.getBoolean("F.status")));
				lista.add(g);
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Gestor obterPorId(int id) {
		Gestor g = new Gestor();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g = new Gestor(rs.getInt("G.id"),
										rs.getInt("G.usuario"),
										rs.getInt("G.senha"),
										new Permissao(rs.getInt("P.id"),
														rs.getString("P.descricao")),
										rs.getBoolean("G.status"),
										new Funcionario(rs.getInt("F.id"),
														rs.getString("F.nome"),
														rs.getString("F.email"),
														rs.getInt("F.contrato"),
														rs.getBoolean("F.status")));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return g;
	}
	
	public Gestor obterPorUsuario(int usuario) {
		Gestor g = new Gestor();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_USUARIO);
			
			ps.setInt(1, usuario);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g = new Gestor(rs.getInt("G.id"),
										rs.getInt("G.usuario"),
										rs.getInt("G.senha"),
										new Permissao(rs.getInt("P.id"),
														rs.getString("P.descricao")),
										rs.getBoolean("G.status"),
										new Funcionario(rs.getInt("F.id"),
														rs.getString("F.nome"),
														rs.getString("F.email"),
														rs.getInt("F.contrato"),
														rs.getBoolean("F.status")));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return g;
	}
	
	public Gestor obterPorFuncionario(Funcionario f) {
		Gestor g = new Gestor();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_FUNCIONARIO);
			
			ps.setInt(1, f.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g = new Gestor(rs.getInt("G.id"),
										rs.getInt("G.usuario"),
										rs.getInt("G.senha"),
										new Permissao(rs.getInt("P.id"),
														rs.getString("P.descricao")),
										rs.getBoolean("G.status"),
										new Funcionario(rs.getInt("F.id"),
														rs.getString("F.nome"),
														rs.getString("F.email"),
														rs.getInt("F.contrato"),
														rs.getBoolean("F.status")));
			}
			
			desconectar();
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return g;
	}
	
	public void excluir(Gestor g) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, g.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
