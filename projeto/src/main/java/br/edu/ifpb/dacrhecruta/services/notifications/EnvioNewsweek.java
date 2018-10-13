package br.edu.ifpb.dacrhecruta.services.notifications;

import br.edu.ifpb.dacrhecruta.dao.NewsweekDao;
import br.edu.ifpb.dacrhecruta.javamail.NotificacoesEmail;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EnvioNewsweek {
    
    @Inject
    private NewsweekDao dao;
    @Inject
    private NotificacoesEmail emails;
    
    @Schedule(second = "1", hour = "*", minute = "*", persistent = false)
    //@Schedule(second = "30", hour = "7", minute = "10", persistent = false, dayOfWeek = "Mon")
    public void enviarNewsweek() {
        System.out.println("enviando newsweek");
        emails.newsweek(dao.vagasNewsweek(), dao.emailsNewsweek());
    }
}
