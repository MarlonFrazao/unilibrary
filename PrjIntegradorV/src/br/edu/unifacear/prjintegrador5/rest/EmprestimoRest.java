package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.EmprestimoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Emprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

@Path("/emprestimo")
public class EmprestimoRest {
	private EmprestimoBusiness business;
	
	public EmprestimoRest() {
		business = new EmprestimoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Emprestimo e) {
		try {
			business.inserir(e);
			return Response.status(201).entity("Emprestimo cadastrado com sucesso!").build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Emprestimo e) {
		try {
			business.alterar(e);
			return Response.status(201).entity("Emprestimo alterado com sucesso!").build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public Response listar() {
		try {
			return Response.status(201).entity(business.listar()).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/id")
	public Response obter(Emprestimo e) {
		try {
			return Response.status(201).entity(business.obter(e.getId())).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/aluno")
	public Response obter(Aluno a) {
		try {
			return Response.status(201).entity(business.obter(a)).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/livro")
	public Response obter(Livro l) {
		try {
			return Response.status(201).entity(business.obter(l)).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Emprestimo e) {
		try {
			business.excluir(e);
			return Response.status(201).entity("Emprestimo excluido com sucesso!").build();
		} catch(Exception ex) {
			return Response.status(201).entity("Erro: " + ex.getMessage()).build();
		}
	}
}
