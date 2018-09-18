package br.edu.ifpb.rhecruta.dao;

import br.edu.ifpb.rhecruta.domain.Gerente;
import br.edu.ifpb.rhecruta.domain.Gerente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class GerenteDAO implements DAO<Gerente> {

    /*@PersistenceContext(
            unitName = "Rhecruta",
            type = PersistenceContextType.EXTENDED
    )*/
    private EntityManager em;

    public GerenteDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }

    @Override
    public void salvar(Gerente obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public Gerente buscar(Object obj) {
        return em.find(Gerente.class, obj);
    }

    @Override
    public void deletar(Gerente obj) {
        em.remove(obj);
    }

    @Override
    public Gerente atualizar(Gerente obj) {
        return em.merge(obj);
    }

}
