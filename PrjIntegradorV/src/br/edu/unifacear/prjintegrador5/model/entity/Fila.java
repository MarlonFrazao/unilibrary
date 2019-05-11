package br.edu.unifacear.prjintegrador5.model.entity;

public class Fila {
	private Integer id;
	private Livro livro;
	private Boolean status;
	
	public Fila() {
		
	}

	public Fila(Integer id, Livro livro, Boolean status) {
		super();
		this.id = id;
		this.livro = livro;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
