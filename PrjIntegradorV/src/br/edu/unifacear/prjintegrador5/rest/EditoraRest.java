package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.EditoraBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;

@Path("/editora")
public class EditoraRest {
	private EditoraBusiness business;
	
	public EditoraRest() {
		business = new EditoraBusiness();
	}
	
	@Path("/inserir")
	@POST
	@Consumes("application/json; charset=UTF-8")
	public Response inserir(Editora e) {
		try {
			business.inserir(e);
			return Response.status(201).entity("Editora cadastrada com sucesso!").build();
		} catch(Exception ex) {
			return Response.status(201).entity("Falha na conexão!").build();
		}
	}
	
	@Path("/alterar")
	@PUT
	@Consumes("application/json; charset=UTF-8")
	public Response alterar(Editora e) {
		try {
			business.alterar(e);
			return Response.status(201).entity("Editora alterada com sucesso!").build();
		} catch (Exception ex) {
			return Response.status(201).entity("Falha na conexão!").build();
		}
	}
	
	@Path("/listar")
	@GET
	@Produces("application/json; charset=UTF-8")
	public Response listar() {
		try {
			return Response.status(201).entity(business.listar()).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Falha na conexão!").build();
		}
	}
	
	@Path("/obter")
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Response obter(Editora e) {
		try{
			return Response.status(201).entity(business.obter(e.getId())).build();
		} catch(Exception ex) {
			return Response.status(201).entity("Falha na conexão!").build();
		}
	}

	@Path("/excluir")
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	public Response excluir(Editora e) {
		try{
			business.excluir(e);
			return Response.status(201).entity("Editora excluida com sucesso!").build();
		} catch(Exception ex) {
			return Response.status(201).entity("Falha na conexão!").build();
		}
	}
}