package br.edu.ifpb.rhecruta.dao;

import br.edu.ifpb.rhecruta.domain.Avaliador;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

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
    public Avaliador buscar(Object obj) {
        return em.find(Avaliador.class, obj);
    }

    @Override
    public void deletar(Avaliador obj) {
        em.remove(obj);
    }

    @Override
    public Avaliador atualizar(Avaliador obj) {
        return em.merge(obj);
    }
}
