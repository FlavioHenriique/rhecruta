package br.edu.ifpb.dac.rhecruta.dao;

import br.edu.ifpb.dac.rhecruta.domain.Avaliador;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AvaliadorDAO implements DAO<Avaliador> {
    private EntityManager em;

    public AvaliadorDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }

    @Override
    public void salvar(Avaliador obj) {
        em.persist(obj);
    }

    @Override
    public Avaliador buscar(Avaliador obj) {
        return em.find(Avaliador.class, obj);
    }

    @Override
    public void deletar(Avaliador obj) {
        em.remove(obj);
    }

    @Override
    public Avaliador atualizar(Avaliador obj) {
        return em.merge(buscar(obj));
    }
}
