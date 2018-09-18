package br.edu.ifpb.rhecruta.dao;

import br.edu.ifpb.rhecruta.domain.Avaliacao;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class AvaliacaoDAO implements DAO<Avaliacao> {

    private EntityManager em;

    public AvaliacaoDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }

    @Override
    public void salvar(Avaliacao obj) {
        em.persist(obj);
    }

    @Override
    public Avaliacao buscar(Object obj) {
        return em.find(Avaliacao.class, obj);
    }

    @Override
    public void deletar(Avaliacao obj) {
        em.remove(obj);
    }

    @Override
    public Avaliacao atualizar(Avaliacao obj) {
        return em.merge(obj);
    }

}
