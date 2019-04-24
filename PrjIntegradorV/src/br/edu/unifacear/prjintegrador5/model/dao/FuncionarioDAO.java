package br.edu.unifacear.prjintegrador5.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;

public class FuncionarioDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO FUNCIONARIOS (nome, email, contrato, status) VALUES ( ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE FUNCIONARIOS SET nome = ?, email = ?, contrato = ?, status = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM FUNCIONARIOS;";
	private String SQL_OBTER_ID = "SELECT * FROM FUNCIONARIOS WHERE id = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM FUNCIONARIOS WHERE id like ?;";
	private String SQL_OBTER_CONTRATO = "SELECT * FROM FUNCIONARIOS WHERE contrato = ?;";
	private String SQL_DELETE = "DELETE FROM FUNCIONARIOS WHERE id = ?;";
	
	public void inserir(Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEmail());
			ps.setInt(3, f.getContrato());
			ps.setBoolean(4, f.getStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEmail());
			ps.setInt(3, f.getContrato());
			ps.setBoolean(4, f.getStatus());
			ps.setInt(5, f.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listar() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Fucionario(rs.getInt("id"),
												rs.getString("nome"),
												rs.getString("email"),
												rs.getInt("contrato"),
												rs.getBoolean("status"));
				lista.add(f);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Funcionario obterPorId(int id) {
		Funcionario f = new Funcionario();
		try{
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Fucionario(rs.getInt("id"),
									rs.getString("nome"),
									rs.getString("email"),
									rs.getInt("contrato"),
									rs.getBoolean("status"));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Funcionario> obterPorNome(String nome) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%' + nome + '%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Fucionario(rs.getInt("id"),
												rs.getString("nome"),
												rs.getString("email"),
												rs.getInt("contrato"),
												rs.getBoolean("status"));
				lista.add(f);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Funcionario obterPorContrato(int contrato) {
		Funcionario f = new Funcionario();
		try{
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_CONTRATO);
			
			ps.setInt(1, contrato);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Fucionario(rs.getInt("id"),
									rs.getString("nome"),
									rs.getString("email"),
									rs.getInt("contrato"),
									rs.getBoolean("status"));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public void excluir(Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setInt(1, f.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
