package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.BusinessException;
import br.edu.unifacear.prjintegrador5.model.business.PermissaoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;

@Path("/permissao")
public class PermissaoRest {
	private PermissaoBusiness business;
	
	public PermissaoRest () {
		business = new PermissaoBusiness();
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/inserir")
	public Response inserir(Permissao p) {
		Response r = null;
		
		try {
			business.inserir(p);
			
			return r.status(200).entity("Permissão inserida com sucesso!").build();
			
		} catch (Exception e) {
			return r.status(200).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public Response alterar(Permissao p) {
		Response r = null;
		
		try {
			business.alterar(p);
			
			return r.status(200).entity("Permissão alterada com sucesso!").build();
			
		} catch(Exception e) {
			return r.status(200).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public Response listar() {
		Response r = null;
		try {
			return r.status(200).entity(business.listar()).build();
		} catch(Exception e) {
			return r.status(200).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	//@GET
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/obter")
	public Response obter(Permissao p) {
		Response r = null;
		
		try {
			
			return r.status(200).entity(business.obter(p.getId())).build();
			
		} catch (Exception e) {
			return r.status(200).entity("Erro: " + e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluir")
	public Response excluir(Permissao p) {
		Response r = null;
		
		try {
			business.excluir(p);
			
			return r.status(200).entity("Permissão excluída com sucesso!").build();
		} catch(Exception e) {
			return r.status(200).entity("Erro: " + e.getMessage()).build();
		}
	}
}
