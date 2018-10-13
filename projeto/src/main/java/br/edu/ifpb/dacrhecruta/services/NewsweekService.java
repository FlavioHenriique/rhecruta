package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.NewsweekDao;
import br.edu.ifpb.dacrhecruta.domain.Newsweek;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NewsweekService {

    @Inject
    private NewsweekDao dao;
    private Newsweek newsweek = new Newsweek();

    public void receber() {
        dao.receberNewsweek(newsweek);
    }

    public Newsweek getNewsweek() {
        return newsweek;
    }

    public void setNewsweek(Newsweek newsweek) {
        this.newsweek = newsweek;
    }

}
