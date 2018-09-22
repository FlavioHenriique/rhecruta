package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.DAO;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
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
@Path("candidato")
public class CandidatoResource {

    @Inject
    //private CandidatoDAO dao;
    private DAO dao;
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
        Candidato c = (Candidato) dao.buscar(email,Candidato.class);
        System.out.println(c.toString());
        return Response.ok().entity(c).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {

        Candidato c = gson.fromJson(json, Candidato.class);
        return Response
                .ok()
                .entity(dao.atualizar(c,c.getEmail()))
                .build();
    }

    @DELETE
    @Path("/{email}")
    public Response deletar(@PathParam("email") String email) {

        dao.deletar(dao.buscar(email,Candidato.class));
        return Response.ok().build();
    }
}
