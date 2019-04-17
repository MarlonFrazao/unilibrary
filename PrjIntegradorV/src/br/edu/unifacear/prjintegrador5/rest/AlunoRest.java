package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.AlunoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

@Path("/aluno")
public class AlunoRest {
	private AlunoBusiness business;
	
	public AlunoRest() {
		business = new AlunoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Aluno a) {
		try {
			business.inserir(a);
			return Response.status(201).entity("Aluno cadastrado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Aluno a) {
		try {
			business.alterar(a);
			return Response.status(201).entity("Aluno alterado com sucesso!").build();
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
		} catch (Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/id")
	public Response obterId(Aluno a) {
		try {
			return Response.status(201).entity(business.obterPorId(a.getId())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/nome")
	public Response obterNome(Aluno a) {
		try {
			return Response.status(201).entity(business.obterPorNome(a.getNome())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build(); 
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/email")
	public Response obterEmail(Aluno a) {
		try {
			return Response.status(201).entity(business.obterPorEmail(a.getEmail())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build(); 
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/matricula")
	public Response obterMatricula(Aluno a) {
		try {
			return Response.status(201).entity(business.obterPorMatricula(a.getMatricula())).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build(); 
		}
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter/curso")
	public Response obterCurso(Curso c) {
		try {
			return Response.status(201).entity(business.obterPorCurso(c)).build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build(); 
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/status")
	public Response alterarStatus(Aluno a) {
		try {
			business.alterarStatus(a.getId());
			return Response.status(201).entity("Status alterado com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
 	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Aluno a) {
		try {
			business.excluir(a);
			return Response.status(201).entity("Aluno excluido com sucesso!").build();
		} catch(Exception e) {
			return Response.status(201).entity("Erro: " + e.getMessage()).build();
		}
	}
}
