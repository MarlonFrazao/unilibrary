package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.FuncionarioBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;

@Path("/funcionario")
public class FuncionarioRest {
	private FuncionarioBusiness business;
	
	public FuncionarioRest() {
		business = new FuncionarioBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Funcionario f) {
		try {
			business.inserir(f);
			return Response.status(201).entity("Funcionario inserido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Funcionario f) {
		try {
			business.alterar(f);
			return Response.status(201).entity("Funcionario alterado com sucesso!").build();
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
	public Response obterPorId(Funcionario f) {
		try {
			return Response.status(201).entity(business.obterPorId(f.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/nome")
	public Response obterPorNome(Funcionario f) {
		try {
			return Response.status(201).entity(business.obterPorNome(f.getNome())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/contrato")
	public Response obterPorContrato(Funcionario f) {
		try {
			return Response.status(201).entity(business.obterPorContrato(f.getContrato())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("alterar/status")
	public Response alterarStatus(Funcionario f) {
		try {
			business.alterarStatus(f);
			return Response.status(201).entity("Status alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Funcionario f) {
		try {
			business.excluir(f);
			return Response.status(201).entity("Funcionario excluido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
