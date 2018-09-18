package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.domain.Candidato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CandidatoDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Candidato c) {
        System.out.println(c.toString());

        em.persist(c);

    }

    public Candidato buscar(Object c) {
        return em.find(Candidato.class, c);
    }

    public void deletar(Candidato c) {

        em.remove(c);
    }

    public Candidato atualizar(Candidato c) {

        em.merge(c);
        return buscar(c);
    }

}
