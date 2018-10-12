package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AvaliacaoDao implements AvaliacaoDaoIF {

    @PersistenceContext
    private EntityManager em;
    @Inject
    private BuscaPyJobs jobs;
    @Inject
    private CandidatoDaoIF candidatoDao;

    @Override
    public void salvar(Avaliacao obj) {
        em.persist(obj);
    }

    @Override
    public List<Avaliacao> buscar(Candidato candidato) {
        List<Avaliacao> lista = em
                .createQuery("SELECT a FROM Avaliacao a WHERE a.candidato = :candidato",
                        Avaliacao.class)
                .setParameter("candidato", candidato)
                .getResultList();
        lista.forEach(a -> a.setVaga(jobs.buscaVaga(a.getCodVaga())));

        return lista;
    }

    @Override
    public List<Avaliacao> buscar() {
        return em
                .createQuery("Select a FROM Avaliacao a", Avaliacao.class)
                .getResultList();
    }

    @Override
    public Avaliacao buscar(Avaliacao obj) {

        Avaliacao a = em.find(Avaliacao.class, obj.getId());
        if (a != null) {
            a.setVaga(jobs.buscaVaga(a.getCodVaga()));
        }
        return a;
    }

    @Override
    public void deletar(Avaliacao obj) {
        em.remove(buscar(obj));
    }

    @Override
    public Avaliacao atualizar(Avaliacao obj) {
        em.merge(obj);
        return this.buscar(obj);
    }

    @Override
    public List<Avaliacao> buscaPorVaga(int id) {
        List<Avaliacao> lista = em
                .createQuery("SELECT a FROM Avaliacao a WHERE a.codVaga = :vaga")
                .setParameter("vaga", id)
                .getResultList();
        lista.forEach(a -> a.setVaga(jobs.buscaVaga(a.getCodVaga())));
        return lista;
    }

    @Override
    public List<Avaliacao> buscaPorCandidato(String email) {
        return buscar(candidatoDao.buscar(email));
    }

}
