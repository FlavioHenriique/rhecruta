package br.edu.ifpb.rhecruta.dao;

import br.edu.ifpb.rhecruta.domain.Candidato;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CandidatoDAO implements DAO<Candidato> {

    /*@PersistenceContext(
            unitName = "Rhecruta",
            type = PersistenceContextType.EXTENDED
    )*/
    private EntityManager em;

    public CandidatoDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }

    @Override
    public void salvar(Candidato c) {
        System.out.println(c.toString());
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public Candidato buscar(Object c) {
        return em.find(Candidato.class, c);
    }

    @Override
    public void deletar(Candidato c) {
        em.remove(c);
    }

    @Override
    public Candidato atualizar(Candidato c) {
        return em.merge(buscar(c));
    }

}
