package br.edu.unifacear.prjintegrador5.model.entity;

public class Curso {
	private Integer id;
	private String descricao;
	private Boolean status;
	
	public Curso() {}

	public Curso(Integer id, String descricao, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
