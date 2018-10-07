package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vaga")
@Stateless
public class VagaResource {

    @Inject
    private BuscaPyJobs busca;
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste(){
        return Response.ok().entity(gson.toJson(busca.okhttp())).build();
    }
}
