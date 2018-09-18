package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.GerenteDAO;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

@Stateless
@Path("gerente")
public class GerenteResource {

    @Inject
    private GerenteDAO dao;
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
        Gerente c = dao.buscar(codigo);
        System.out.println(c.toString());
        return Response.ok().entity(c).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {

        return Response
                .ok()
                .entity(
                        dao.atualizar(
                                gson.fromJson(json, Gerente.class)
                        )
                )
                .build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response deletar(@PathParam("codigo") int codigo) {

        dao.deletar(dao.buscar(codigo));
        return Response.ok().build();
    }
}
