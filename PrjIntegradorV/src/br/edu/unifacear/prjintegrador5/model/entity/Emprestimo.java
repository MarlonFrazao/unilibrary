package br.edu.unifacear.prjintegrador5.model.entity;

import java.sql.Date;

public class Emprestimo {
	private Integer id;
	private Aluno aluno;
	private Livro livro;
	private Date dataInicio;
	private Date dataFinal;
	private Boolean status;
	
	public Emprestimo() {}

	public Emprestimo(Integer id, Aluno aluno, Livro livro, Date dataInicio, Date dataFinal, Boolean status) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.livro = livro;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.status = status;
	}

	public Integer getId() {
		return id;
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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
