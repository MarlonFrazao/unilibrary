package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.FilaBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

@Path("/fila")
public class FilaRest {
	private FilaBusiness business;
	
	public FilaRest() {
		business = new FilaBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Fila f) {
		try {
			business.inserir(f);
			return Response.status(201).entity("Inserido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Fila f) {
		try {
			business.alterar(f);
			return Response.status(201).entity("Alterado con sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro; " + e.getMessage()).build();
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
	public Response obter(Fila f) {
		try {
			return Response.status(201).entity(business.obter(f.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/livro")
	public Response obter(Livro l) {
		try {
			return Response.status(201).entity(business.obter(l)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Fila f) {
		try {
			business.excluir(f);
			return Response.status(201).entity("Excluido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
