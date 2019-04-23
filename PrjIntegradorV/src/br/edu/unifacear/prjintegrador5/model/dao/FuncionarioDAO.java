package br.edu.unifacear.prjintegrador5.model.dao;

public class FuncionarioDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO FUNCIONARIOS (nome, email, contrato, status) VALUES ( ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE FUNCIONARIOS SET nome = ?, email = ?, contrato = ?, status = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM FUNCIONARIOS;";
	private String SQL_OBTER_ID = "SELECT * FROM FUNCIONARIOS WHERE id = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM FUNCIONARIOS WHERE id like ?;";
	private String SQL_OBTER_CONTRATO = "SELECT * FROM FUNCIONARIOS WHERE contrato = ?;";
	private String SQL_DELETE = "DELETE FROM FUNCIONARIOS WHERE id = ?;";
}
