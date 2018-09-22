package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.DAO;
import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("avaliador")
@Stateless
public class AvaliadorResource {
    
    @Inject
    //private AvaliadorDAO dao;
    private DAO dao;
    private Gson gson = new Gson();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(String json) {

        dao.salvar(gson.fromJson(json, Avaliador.class));
        return Response.ok().build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarAvaliador(@PathParam("codigo") int codigo) {
        Avaliador a = (Avaliador) dao.buscar(codigo,Avaliador.class);

        if(a != null){
            return Response.ok().entity(a).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {
        Avaliador a = gson.fromJson(json, Avaliador.class);
        return Response
                .ok()
                .entity(dao.atualizar(a,a.getCodigo()))
                .build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response deletar(@PathParam("codigo") int codigo) {

        dao.deletar(dao.buscar(codigo,Avaliador.class));
        return Response.ok().build();
    }
}
