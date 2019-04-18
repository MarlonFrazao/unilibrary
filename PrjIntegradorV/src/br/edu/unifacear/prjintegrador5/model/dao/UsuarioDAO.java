package br.edu.unifacear.prjintegrador5.model.dao;

public class UsuarioDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO USUARIOS (usuario, senha, permissaoid, status, alunoid) values (?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE USUARIOS SET usuario = ?, senha = ?, permissaoid = ?, status = ?, alunoid = ? WHERE id = ?;";
	private String SQL_SELECT = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES P ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id;";
	private String SQL_OBTER_ID = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES p ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id WHERE U.id = ?;";
	private String SQL_OBTER_USUARIO = "SELECT * FROM USUARIOS U INNER JOIN PERMISSOES p ON U.permissaoid = P.id INNER JOIN alunos A ON U.alunoid = A.id WHERE U.usuario = ?;";
	private String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID = ?;";
}
