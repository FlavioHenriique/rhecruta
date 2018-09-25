package br.edu.ifpb.dacrhecruta.pyjobs;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import okhttp3.Request;

@Stateless
public class BuscaPyJobs {

    private final static String url = "http://www.pyjobs.com.br/api/jobs/";
    private OkHttpClient client;
    private Gson gson;

    public BuscaPyJobs() {
        gson = new Gson();
        client = new OkHttpClient();
    }

    public List<Vaga> buscaVagas() {
        Request request = new Request.Builder().url(url).get().build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject(response.body().string());
            JSONArray j = json.getJSONArray("objects");
            return Arrays.asList(gson.fromJson(j.toString(), Vaga[].class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }


    public String buscaCidade(String cidade){

        return gson.toJson(
                buscaVagas()
                .stream()
                .filter(v->v.getWorkplace().equals(cidade))
                .collect(Collectors.toList())
        );
    }
}
