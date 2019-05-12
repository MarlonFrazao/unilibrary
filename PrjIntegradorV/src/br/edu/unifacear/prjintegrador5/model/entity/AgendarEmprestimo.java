package br.edu.unifacear.prjintegrador5.model.entity;

public class AgendarEmprestimo {
	private Integer id;
	private Aluno aluno;
	private Boolean status;
	private Fila fila;
	
	public AgendarEmprestimo() {
	
	}

	public AgendarEmprestimo(Integer id, Aluno aluno, Boolean status, Fila fila) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.status = status;
		this.fila = fila;
	}
	
	public Integer getId() {
		return this.id;	
	}
	
	public void setId(Integer id) {
		this.id = id;	
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
}
