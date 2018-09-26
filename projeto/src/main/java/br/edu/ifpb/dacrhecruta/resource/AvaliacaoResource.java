package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("avaliacao")
@Stateless
public class AvaliacaoResource {

    @Inject
    private AvaliacaoDaoIF dao;
    private Gson gson = new Gson();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(String json) {

        dao.salvar(gson.fromJson(json, Avaliacao.class));
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarAvaliacao(@PathParam("id") int id) {

        Avaliacao a = new Avaliacao();
        a.setId(id);
        a = dao.buscar(a);

        if(a != null){
            return Response.ok().entity(a).build();
        }
        else {
            return Response.noContent().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {
        Avaliacao a = gson.fromJson(json, Avaliacao.class);
        return Response
                .ok()
                .entity(dao.atualizar(a))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {

        Avaliacao a = new Avaliacao();
        a.setId(id);
        a = dao.buscar(a);
        dao.deletar(dao.buscar(a));
        return Response.ok().build();
    }
}
