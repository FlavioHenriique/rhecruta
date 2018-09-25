package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("cidade/{cidade}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaCidade(@PathParam("cidade") String cidade){
        return Response
                .ok()
                .entity(busca.buscaCidade(cidade.toLowerCase()))
                .build();
    }

    @GET
    @Path("descricao/{descricao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaDescricao(@PathParam("descricao") String descricao){
        return Response
                .ok()
                .entity(busca.buscaDescricao(descricao.toLowerCase()))
                .build();
    }

    @GET
    @Path("empresa/{empresa}")
    public Response buscaEmpresa(@PathParam("empresa") String empresa){
        return Response
                .ok()
                .entity(busca.buscaEmpresa(empresa.toLowerCase()))
                .build();
    }
}