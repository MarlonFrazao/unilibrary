package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Editora;

public class EditoraDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO EDITORAS (razaosocial, endereco, site, email) values(?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE EDITORAS SET razaosocial = ?, endereco = ?, site = ?, email = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM EDITORAS;";
	private String SQL_DELETE = "DELETE FROM EDITORAS WHERE id = ?;";
	private String SQL_OBTER = "SELECT * FROM EDITORAS WHERE id = ?;";
	
	public void inserir(Editora ed) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, ed.getRazaoSocial());
			ps.setString(2, ed.getEndereco());
			ps.setString(3, ed.getSite());
			ps.setString(4, ed.getEmail());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Editora ed) {
		try{
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, ed.getRazaoSocial());
			ps.setString(2, ed.getEndereco());
			ps.setString(3, ed.getSite());
			ps.setString(4, ed.getEmail());
			ps.setInt(5, ed.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}  
	} 
	
	public List<Editora> listar() {
		List<Editora> lista = new ArrayList<Editora>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Editora ed = new Editora(rs.getInt("id"),
											rs.getString("razaosocial"),
											rs.getString("endereco"),
											rs.getString("site"),
											rs.getString("email"));
											
				lista.add(ed);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return lista;
	}
	
	public void excluir(Editora ed) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, ed.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Editora obter(int id) {
		Editora ed = new Editora();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ed = new Editora(rs.getInt("id"),
									rs.getString("razaosocial"),
									rs.getString("endereco"),
									rs.getString("site"),
									rs.getString("email"));					
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ed;
	}
}