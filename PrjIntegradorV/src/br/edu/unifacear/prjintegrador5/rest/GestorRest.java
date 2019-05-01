package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.GestorBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Gestor;
import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;

@Path("/gestor")
public class GestorRest {
	private GestorBusiness business;
	
	public GestorRest() {
		business = new GestorBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Gestor g) {
		try {
			business.inserir(g);
			return Response.status(201).entity("Gestor cadastrado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT 
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Gestor g) {
		try {
			business.alterar(g);
			return Response.status(201).entity("Gestor alterado com sucesso!").build();
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
	@Path("obter/id")
	public Response obterPorId(Gestor g) {
		try {
			return Response.status(201).entity(business.obterPorId(g.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/usuario")
	public Response obterPorUsuario(Gestor g) {
		try {
			return Response.status(201).entity(business.obterPorUsuario(g.getUsuario())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/funcionario")
	public Response obterPorFuncionario(Funcionario f) {
		try {
			return Response.status(201).entity(business.obterPorFuncionario(f)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/status")
	public Response alterarStatus(Gestor g) {
		try {
			business.alterarStatus(g);
			return Response.status(201).entity("Status alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Gestor g) {
		try {
			business.excluir(g);
			return Response.status(201).entity("Gestor excluido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/login")
	public Response login(Gestor g) {
		try {
			if(business.login(g.getUsuario(), g.getSenha())) {
				return Response.status(201).entity(business.obterPorUsuario(g.getUsuario())).build();
			} else {
				return Response.status(201).entity(false).build();
			}
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
