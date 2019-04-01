package br.edu.unifacear.prjintegrador5.model.entity;

public class Permissao {
	private int id;
	private String descricao;
	
	public Permissao() {}
	
	public Permissao(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
