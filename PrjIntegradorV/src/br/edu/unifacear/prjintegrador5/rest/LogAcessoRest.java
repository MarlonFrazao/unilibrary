package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.LogAcessoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.LogAcesso;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

@Path("/acessos")
public class LogAcessoRest {
	private LogAcessoBusiness business;
	
	public LogAcessoRest() {
		business = new LogAcessoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset = UTF-8")
	@Path("/inserir")
	public Response inserir(LogAcesso l) {
		try{
			business.inserir(l);
			return Response.status(201).entity("Log inserido!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset = UTF-8")
	@Path("/alterar")
	public Response alterar(LogAcesso l) {
		try {
			business.alterar(l);
			return Response.status(201).entity("Log alterado!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json; charset = UTF-8")
	@Path("/listar")
	public Response listar() {
		try {
			return Response.status(201).entity(business.listar()).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset = UTF-8")
	@Produces("application/json; charset = UTF-8")
	@Path("/obter/id")
	public Response obter(LogAcesso l) {
		try {
			return Response.status(201).entity(business.obter(l.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset = UTF-8")
	@Produces("application/json; charset = UTF-8")
	@Path("/obter/usuario")
	public Response obter(Usuario u) {
		try {
			return Response.status(201).entity(business.obter(u)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset = UTF-8")
	@Path("/excluir")
	public Response excluir(LogAcesso l) {
		try {
			business.excluir(l);
			return Response.status(201).entity("Log excluido!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
