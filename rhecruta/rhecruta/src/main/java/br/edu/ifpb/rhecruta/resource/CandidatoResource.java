package br.edu.ifpb.rhecruta.resource;

import br.edu.ifpb.rhecruta.dao.CandidatoDAO;
import br.edu.ifpb.rhecruta.dao.GerenteDAO;
import br.edu.ifpb.rhecruta.domain.Candidato;
import br.edu.ifpb.rhecruta.domain.Gerente;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("candidato")
public class CandidatoResource {
    
    private CandidatoDAO dao = new CandidatoDAO();
    private Gson gson = new Gson();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(String json) {
        
        dao.salvar(gson.fromJson(json, Candidato.class));
        return Response.ok().build();
    }
    
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCandidato(@PathParam("email") String email) {
        
        return Response.ok().entity(dao.buscar(email)).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {
        
        return Response
                .ok()
                .entity(
                        dao.atualizar(
                                gson.fromJson(json, Candidato.class)
                        )
                )
                .build();
    }
    
    @DELETE
    @Path("/{email}")
    public Response deletar(@PathParam("email") String email) {
        
        dao.deletar(dao.buscar(email));
        return Response.ok().build();
    }
}
