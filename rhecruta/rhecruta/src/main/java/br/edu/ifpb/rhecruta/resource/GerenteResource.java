package br.edu.ifpb.rhecruta.resource;

import br.edu.ifpb.rhecruta.dao.GerenteDAO;
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

@Path("gerente")
public class GerenteResource {

    private GerenteDAO dao = new GerenteDAO();
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
    public Response buscar(@PathParam("codigo") int codigo) {

        return Response
                .ok()
                .entity(dao.buscar(codigo))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {

        return Response
                .ok()
                .entity(dao.atualizar(gson
                        .fromJson(json, Gerente.class)))
                .build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response deletar(@PathParam("codigo") int codigo) {

        dao.deletar(dao.buscar(codigo));

        return Response
                .ok()
                .build();
    }

}
