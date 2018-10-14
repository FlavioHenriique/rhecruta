package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.domain.Vaga;
import com.google.gson.Gson;
import org.json.JSONObject;

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
    private CandidatoDaoIF dao;
    //private DAO dao;
    private Gson gson = new Gson();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response autenticar(String json){
        JSONObject jobj = new JSONObject(json);
        Candidato c = dao.autenticar(jobj.getString("email"),
                jobj.getString("senha"));

        if(c  != null){
            return Response.ok().entity(c).build();
        }else{
            return Response.noContent().build();
        }
    }

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
        //Candidato c = (Candidato) dao.buscar(email,Candidato.class);
        
        Candidato c = new Candidato();
        c.setEmail(email);
        c = dao.buscar(c);
        
        System.out.println(c.toString());
        if(c != null){
            return Response.ok().entity(c).build();
        }else{
            return Response.noContent().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(String json) {

        Candidato c = gson.fromJson(json, Candidato.class);
        if(c != null){
            c = dao.atualizar(c);
            return Response.ok().entity(c).build();
        }else{
            return Response.noContent().build();
        }
    }

    @PUT
    @Path("/{email}/removerInteresse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removerInteresse(String json, @PathParam("email") String email) {

        Candidato c = new Candidato();
        c.setEmail(email);
        c = dao.buscar(c);

        Vaga v = gson.fromJson(json, Vaga.class);
        
        if(c != null && v != null){
            c = dao.removerInteresse(c, v);
            return Response.ok().entity(c).build();
        }else{
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("/{email}")
    public Response deletar(@PathParam("email") String email) {
        
        Candidato c = new Candidato();
        c.setEmail(email);
        c = dao.buscar(c);

        dao.deletar(dao.buscar(c));
        return Response.ok().build();
    }
}
