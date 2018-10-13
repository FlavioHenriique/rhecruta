package br.edu.ifpb.dacrhecruta.javamail;

import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Vaga;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class NotificacoesEmail {

    @Inject
    private EnviaEmail enviaEmail;

    public NotificacoesEmail(EnviaEmail enviaEmail) {
        this.enviaEmail = enviaEmail;
    }

    public NotificacoesEmail() {

    }

    public void finalizarRecrutamento(Avaliacao avaliacao) {

        String titulo = "Finalização do processo de recrutamento para a vaga: "
                + avaliacao.getVaga().getTitle();
        String corpo = (avaliacao.isAprovacao()) ? "Aprovado" : "Reprovado";

        enviaEmail.enviar(avaliacao.getCandidato().getEmail(), titulo, corpo);
    }

    public void lembrete(Avaliacao avaliacao) {

        String titulo = "Rhecruta: Avaliações e entrevistas";
        String corpo = "Gostaríamos de lembrá-lo que há uma entrevista marcada para hoje."
                + "\n Vaga: " + avaliacao.getVaga().getTitle() + " \n"
                + "Horário: " + avaliacao.getHorario();

        enviaEmail.enviar(avaliacao.getCandidato().getEmail(), titulo, corpo);
    }

    public void newsweek(List<Vaga> vagas, List<String> emails) {
        String titulo = "Rhecruta: Newsweek";
        String corpo = "Olá, gostaríamos de informá-lo das vagas que surgiram na semana!"
                + "\n ";
        for (Vaga v : vagas) {
            corpo += v.getTitle() + "\n" + v.getWorkplace() + "\n \n";
        }
        if (!emails.isEmpty()) {
            String destinatarios = "";
            for (String s : emails) {
                destinatarios += s + ",";
            }
            enviaEmail.enviar(
                    destinatarios.substring(0, destinatarios.length() - 1),
                    titulo,
                    corpo
            );
        } else {
            System.out.println("sem destinatários");
        }

    }
}
