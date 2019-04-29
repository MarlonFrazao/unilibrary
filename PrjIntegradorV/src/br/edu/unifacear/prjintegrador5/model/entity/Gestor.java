package br.edu.unifacear.prjintegrador5.model.entity;

public class Gestor {
	private Integer id;
	private Integer usuario;
	private Integer senha;
	private Permissao permissao;
	private Boolean status;
	private Funcionario funcionario;
	
	public Gestor() {}

	public Gestor(Integer id, Integer usuario, Integer senha, 
			Permissao permissao, Boolean status, Funcionario funcionario) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
		this.status = status;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
