package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.business.LivroBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

@Path("/livro")
public class LivroRest {
	private LivroBusiness business;
    
    public LivroRest() {
            business = new LivroBusiness();
    }
    
    @Path("/inserir")
    @Consumes("application/json; charset=UTF-8")
    @POST
    public Response inserir(Livro l) {
            try {
                    business.inserir(l);
                    return Response.status(200).entity("Livro cadastrado com sucesso!").build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
    
    @Path("/alterar")
    @Consumes("application/json; charset=UTF-8")
    @PUT
    public Response alterar(Livro l) {
            try {
                    business.alterar(l);
                    return Response.status(200).entity("Livro atualizado com sucesso!").build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
    
    @Path("/listar")
    @Produces("application/json; charset=UTF-8")
    @GET
    public Response listar() {
            try {
                    return Response.status(200).entity(business.listar()).build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
    
    @Path("/obter_id")
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @POST
    public Response obterId(Livro l) {
            try{
                    return Response.status(200).entity(business.obter(l.getId())).build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
    
    @Path("/obter_titulo")
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @POST
    public Response obterTitulo(Livro l) {
            try {
                    return Response.status(200).entity(business.obter(l.getTitulo())).build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
    
    @Path("/obter_autor")
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @POST
    public Response obterAutor(Autor a) {
    	try {
    		return Response.status(200).entity(business.obter(a)).build();
    	} catch(Exception e) {
    		return Response.status(200).entity("Erro: " + e.getMessage()).build(); 		
    	}
    }
    
    @Path("/excluir")
    @Consumes("application/json; charset=UTF-8")
    @DELETE
    public Response excluir(Livro l) {
            try {
                    business.excluir(l);
                    return Response.status(200).entity("Livro excluído com sucesso!").build();
            } catch(Exception e) {
                    return Response.status(200).entity("Erro: " + e.getMessage()).build();
            }
    }
}
