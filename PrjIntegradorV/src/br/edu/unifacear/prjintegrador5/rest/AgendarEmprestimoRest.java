package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.AgendarEmprestimoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.AgendarEmprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;

@Path("/agendar/emprestimo")
public class AgendarEmprestimoRest {
	private AgendarEmprestimoBusiness business;
	
	public AgendarEmprestimoRest() {
		business = new AgendarEmprestimoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(AgendarEmprestimo a) {
		try {
			business.inserir(a);
			return Response.status(201).entity("Agendamento cadastrado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(AgendarEmprestimo a) {
		try {
			business.alterar(a);
			return Response.status(201).entity("Agendamento alterado com sucesso!").build();
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
	public Response obter(AgendarEmprestimo a) {
		try {
			return Response.status(201).entity(business.obter(a.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/aluno")
	public Response obter(Aluno a) {
		try {
			return Response.status(201).entity(business.obter(a)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/obter/fila")
	public Response obter(Fila f) {
		try {
			return Response.status(201).entity(business.obter(f)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(AgendarEmprestimo a) {
		try {
			business.excluir(a);
			return Response.status(201).entity("Agendamento cancelado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
