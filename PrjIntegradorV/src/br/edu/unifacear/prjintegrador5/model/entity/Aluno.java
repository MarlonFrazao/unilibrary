package br.edu.unifacear.prjintegrador5.model.entity;

public class Aluno {
	private Integer id;
	private String nome;
	private String email;
	private Curso curso;
	private Boolean status;
	private Integer matricula;
	
	public Aluno() {}

	public Aluno(Integer id, String nome, String email, Curso curso, 
			Boolean status, Integer matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.curso = curso;
		this.status = status;
		this.matricula = matricula;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
}
