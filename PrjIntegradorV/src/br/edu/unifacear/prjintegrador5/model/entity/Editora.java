package br.edu.unifacear.prjintegrador5.model.entity;

public class Editora {
	private Integer id;
	private String razaoSocial;
	private String endereco;
	private String site;
	private String email;
	
	public Editora(){ }
	public Editora(int id, String razaoSocial, String endereco, String site, String email) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.site = site;
		this.email = email;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return this.razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getSite() {
		return this.site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
} 