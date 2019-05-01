package br.edu.unifacear.prjintegrador5.model.entity;

import java.sql.Date;

public class LogAcesso {
	private Integer id;
	private Usuario usuario;
	private Date inicio;
	private Date fim;
	
	public LogAcesso() {}

	public LogAcesso(Integer id, Usuario usuario, Date inicio, Date fim) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
}
