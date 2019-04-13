package br.edu.unifacear.prjintegrador5.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.business.AutorBusiness;

@Path("/autor")
public class AutorRest {  
        private AutorBusiness business;
        
        public AutorRest() {
                business = new AutorBusiness();
        }
        
        @Path("/inserir")
        @Consumes("application/json; charset=UTF-8")
        @POST
        public Response inserir(Autor a) {
                try {
                        business.inserir(a);
                        return Response.status(200).entity("Autor cadastrado com sucesso!").build();
                } catch(Exception e) {
                        return Response.status(200).entity("Erro: " + e.getMessage()).build();
                }
        }
        
        @Path("/alterar")
        @Consumes("application/json; charset=UTF-8")
        @PUT
        public Response alterar(Autor a) {
                try {
                        business.alterar(a);
                        return Response.status(200).entity("Autor atualizado com sucesso!").build();
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
        
        @Path("/obter/id")
        @Produces("application/json; charset=UTF-8")
        @Consumes("application/json; charset=UTF-8")
        @POST
        public Response obterId(Autor a) {
                try{
                        return Response.status(200).entity(business.obter(a.getId())).build();
                } catch(Exception e) {
                        return Response.status(200).entity("Erro: " + e.getMessage()).build();
                }
        }
        
        @Path("/obter/nome")
        @Produces("application/json; charset=UTF-8")
        @Consumes("application/json; charset=UTF-8")
        @POST
        public Response obterNome(Autor a) {
                try {
                        return Response.status(200).entity(business.obter(a.getNome())).build();
                } catch(Exception e) {
                        return Response.status(200).entity("Erro: " + e.getMessage()).build();
                }
        }
        
        @Path("/excluir")
        @Consumes("application/json; charset=UTF-8")
        @DELETE
        public Response excluir(Autor a) {
                try {
                        business.excluir(a);
                        return Response.status(200).entity("Autor excluído com sucesso!").build();
                } catch(Exception e) {
                        return Response.status(200).entity("Erro: " + e.getMessage()).build();
                }
        }
}
