package br.edu.unifacear.prjintegrador5.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifacear.prjintegrador5.db.ConnectDB;


public class DAO {
	protected ConnectDB db;
	protected Connection connection;
	
	public DAO () {
		db = new ConnectDB();
	}
	
	public void conectar() throws ClassNotFoundException, IOException, SQLException {
		if(connection == null)
			connection = db.getConnection();
	}
	
	public void desconectar() throws SQLException {
		if(connection != null)
			connection.close();
	}
}
