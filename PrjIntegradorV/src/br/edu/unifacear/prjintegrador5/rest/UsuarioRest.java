package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.UsuarioBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

@Path("/usuario")
public class UsuarioRest {
	private UsuarioBusiness business;
	
	public UsuarioRest() {
		business = new UsuarioBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Usuario u) {
		try {
			business.inserir(u);
			return Response.status(201).entity("Usuario cadastrado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Usuario u) {
		try {
			business.alterar(u);
			return Response.status(201).entity("Usuario alterado com sucesso!").build();
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
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/id")
	public Response obterPorId(Usuario u) {
		try {
			return Response.status(201).entity(business.obterPorId(u.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/usuario")
	public Response obterPorUsuario(Usuario u) {
		try {
			return Response.status(201).entity(business.obterPorUsuario(u.getUsuario())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/status")
	public Response alterarStatus(Usuario u) {
		try {
			business.alterarStatus(u);
			return Response.status(201).entity("Status alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Usuario u) {
		try {
			business.excluir(u);
			return Response.status(201).entity("Usuario excluido com sucesso!").build();
		}catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/login")
	public Response login(Usuario u) {
		try {
			return Response.status(201).entity(business.login(u.getUsuario(), u.getSenha())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
