package br.edu.ifpb.dacrhecruta.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Object Object) {

        em.persist(Object);
    }

    public Object buscar(Object key, Class classe) {
        return em.find(classe,key);
    }

    public void deletar(Object Object) {

        em.remove(Object);

    }

    public Object atualizar(Object obj, Object key) {

        em.merge(obj);
        return buscar(key, obj.getClass());
    }
}
