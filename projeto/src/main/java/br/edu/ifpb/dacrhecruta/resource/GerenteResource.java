package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("gerente")
public class GerenteResource {

    @Inject
    private GerenteDaoIF dao;
    //private DAO dao;
    private Gson gson = new Gson();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(String json) {

        dao.salvar(gson.fromJson(json, Gerente.class));
        return Response.ok().build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarGerente(@PathParam("codigo") int codigo) {
        //Gerente c = dao.buscar(codigo);
        //Gerente c = (Gerente) dao.buscar(codigo,Gerente.class);
        
        Gerente c = new Gerente();
        c.setCodigo(codigo);
        c = dao.buscar(c);
        
        if(c != null){
            return Response.ok().entity(c).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {

        Gerente g = gson.fromJson(json, Gerente.class);
        return Response
                .ok()
                .entity(dao.atualizar(g))
                .build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response deletar(@PathParam("codigo") int codigo) {
        
        Gerente c = new Gerente();
        c.setCodigo(codigo);
        c = dao.buscar(c);

        dao.deletar(dao.buscar(c));
        return Response.ok().build();
    }
}
