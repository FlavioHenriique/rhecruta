package br.edu.ifpb.dacrhecruta.pyjobs;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Request;

@Stateless
public class BuscaPyJobs {

    private final static String url = "http://www.pyjobs.com.br/api/jobs/";
    private WebTarget target;
    private Gson gson;

    public BuscaPyJobs() {
        Client client = ClientBuilder.newClient();
        target = client.target(url);
        gson = new Gson();
    }

    public List<Vaga> okhttp() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject(response.body().string());
            JSONArray j = json.getJSONArray("objects");
            return Arrays.asList(gson.fromJson(j.toString(), Vaga[].class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public String teste() {
        System.out.println("porra");
        Response response = target
                .request()
                .header("Accept", "application/json")
                .get();
        JSONObject json = new JSONObject(response.readEntity(String.class));
        JSONObject object = new JSONObject(json.get("objects").toString());
        return object.toString();
    }

}
