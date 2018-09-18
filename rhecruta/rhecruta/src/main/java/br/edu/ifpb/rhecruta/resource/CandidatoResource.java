package br.edu.ifpb.rhecruta.resource;

import br.edu.ifpb.rhecruta.dao.CandidatoDAO;
import br.edu.ifpb.rhecruta.dao.GerenteDAO;
import br.edu.ifpb.rhecruta.domain.Candidato;
import br.edu.ifpb.rhecruta.domain.Gerente;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("candidato")
public class CandidatoResource {

    private CandidatoDAO dao = new CandidatoDAO();
    private Gson gson = new Gson();
    private GerenteDAO g = new GerenteDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(String json) {

        g.salvar(gson.fromJson(json, Gerente.class));
        return Response.ok().build();
    }

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCandidato(@PathParam("email") String email) {

        return Response.ok().entity(dao.buscar(email)).build();
    }

}
