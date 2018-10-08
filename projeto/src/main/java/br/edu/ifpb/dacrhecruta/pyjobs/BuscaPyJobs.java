package br.edu.ifpb.dacrhecruta.pyjobs;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.Request;

@Stateless
public class BuscaPyJobs {

    private final static String url = "http://www.pyjobs.com.br/api/jobs/?limit=80";
    private OkHttpClient client;
    private Gson gson;

    public BuscaPyJobs() {
        gson = new Gson();
        client = new OkHttpClient();
    }

    private List<Vaga> buscaVagas() {
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

    public String buscaCidade(String cidade) {
        return gson.toJson(
                buscaVagas()
                        .stream()
                        .filter(v -> v.getWorkplace().toLowerCase().contains(cidade))
                        .collect(Collectors.toList())
        );
    }

    public String buscaDescricao(String descricao) {
        return gson.toJson(
                buscaVagas()
                        .stream()
                        .filter(v -> v.getDescription().toLowerCase().contains(descricao))
                        .collect(Collectors.toList())
        );
    }

    public String buscaEmpresa(String empresa) {
        return gson.toJson(
                buscaVagas()
                        .stream()
                        .filter(v -> v.getCompany_name().toLowerCase().contains(empresa))
                        .collect(Collectors.toList())
        );
    }

    public List<Vaga> interessesCandidato(List<Integer> vagas) {
        List<Vaga> interesses = new ArrayList<>();
        vagas.forEach(vaga -> {
            interesses.addAll(
                    this.buscaVagas()
                            .stream()
                            .filter(v -> v.getId() == vaga)
                            .collect(Collectors.toList())
            );
        });
        return interesses;
    }

    public Vaga buscaVaga(int id) {
        return this.buscaVagas()
                .stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .get();
    }
}
