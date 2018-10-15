package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.domain.Newsweek;
import br.edu.ifpb.dacrhecruta.domain.Vaga;
import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NewsweekDao {

    @PersistenceContext
    private EntityManager em;
    @Inject
    private BuscaPyJobs jobs;

    public List<String> emailsNewsweek() {
        return em.createQuery("SELECT n.email FROM Newsweek n").getResultList();
    }

    public List<Vaga> vagasNewsweek() {
        List<Integer> vagas = em
                .createNativeQuery("SELECT DISTINCT vagas FROM candidato_vagas")
                .getResultList();
        List<Vaga> vagasNewsweek = new ArrayList<>();
        for (Integer v : vagas) {
            if(v!= null){
                vagasNewsweek.add(jobs.buscaVaga(v));
            }
        }
        return vagasNewsweek;
    }

    public void receberNewsweek(Newsweek newsweek) {
        if (buscar(newsweek) == null) {
            em.persist(newsweek);
        }
    }

    public Newsweek buscar(Newsweek n) {
        return em.find(Newsweek.class, n.getEmail());
    }
}
