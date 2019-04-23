package br.edu.unifacear.prjintegrador5.model.entity;

public class Funcionario {
	private Integer id;
	private String nome;
	private String email;
	private Integer contrato;
	private Boolean status;
	
	public Funcionario() {}

	public Funcionario(Integer id, String nome, String email, Integer contrato, Boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.contrato = contrato;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer contrato) {
		this.contrato = contrato;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
