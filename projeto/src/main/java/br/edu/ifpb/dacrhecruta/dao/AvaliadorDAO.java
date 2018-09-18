package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AvaliadorDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Avaliador a) {
        em.persist(a);
    }

    public Avaliador buscar(int a) {
        return em.find(Avaliador.class, a);
    }

    public void deletar(Avaliador a) {

        em.remove(a);
    }

    public Avaliador atualizar(Avaliador a) {

        em.merge(a);
        return buscar(a.getCodigo());
    }

}
