package br.edu.ifpb.dac.rhecruta.dao;

import br.edu.ifpb.dac.rhecruta.domain.Gerente;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GerenteDAO implements DAO<Gerente> {

    private EntityManager em;

    public GerenteDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }
    @Override
    public void salvar(Gerente obj) {
        em.persist(obj);
    }

    @Override
    public Gerente buscar(Gerente obj) {
        return em.find(Gerente. class,obj);
    }

    @Override
    public void deletar(Gerente obj) {
        em.remove(obj);
    }

    @Override
    public Gerente atualizar(Gerente obj) {
        return em.merge(buscar(obj));
    }
}
