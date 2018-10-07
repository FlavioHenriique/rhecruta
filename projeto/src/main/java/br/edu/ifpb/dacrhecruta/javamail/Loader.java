package br.edu.ifpb.dacrhecruta.javamail;

import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Loader {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .get().url("http://localhost:8081/rhecruta/api/avaliacao/1")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Avaliacao a = gson.fromJson(response.body().string(),Avaliacao.class);
            Candidato c = a.getCandidato();
            c.setEmail("flaviohenrique638@gmail.com");
            a.setCandidato(c);
            NotificacoesEmail n = new NotificacoesEmail(new EnviaEmail());
            //n.finalizarRecrutamento(a);
            n.lembrete(a);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
