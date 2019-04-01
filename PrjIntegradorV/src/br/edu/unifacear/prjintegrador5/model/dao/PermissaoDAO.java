package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Permissao;

public class PermissaoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO PERMISSOES (descricao) values (?);";
	private String SQL_UPDATE = "UPDATE PERMISSOES SET descricao = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM PERMISSOES;";
	private String SQL_DELETE = "DELETE FROM PERMISSOES WHERE id = ?;";
	private String SQL_OBTER = "SELECT * FROM PERMISSOES WHERE id = ?;";
	
	public void inserir(Permissao p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			
			ps.setString(1, p.getDescricao());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Permissao p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, p.getDescricao());
			ps.setInt(2, p.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Permissao> listar() {
		List<Permissao> lista = new ArrayList<Permissao>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Permissao p = new Permissao(rs.getInt("id"), rs.getString("descricao"));
				
				lista.add(p);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(Permissao p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, p.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public Permissao obter(int id) {
		Permissao p = new Permissao();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p = new Permissao(rs.getInt("id"), rs.getString("descricao"));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
