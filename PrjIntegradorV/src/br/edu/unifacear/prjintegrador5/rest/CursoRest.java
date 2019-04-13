package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.CursoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

@Path("/curso")
public class CursoRest {
	private CursoBusiness business;
	
	public CursoRest() {
		business = new CursoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Curso c) {
		try {
			business.inserir(c);
			return Response.status(201).entity("Curso cadastrado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Curso c) {
		try {
			business.alterar(c);
			return Response.status(201).entity("Curso alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public Response listar() {
		try {
			return Response.status(201).entity(business.listar()).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/id")
	public Response obterId(Curso c) {
		try {
			return Response.status(201).entity(business.obter(c.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/descricao")
	public Response obterDescricao(Curso c) {
		try {
			return Response.status(201).entity(business.obter(c.getDescricao())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build(); 
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/status")
	public Response alterarStatus(Curso c) {
		try {
			business.alterarStatus(c.getId());
			return Response.status(201).entity("Status alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Curso c) {
		try {
			business.excluir(c);
			return Response.status(201).entity("Curso excluido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
