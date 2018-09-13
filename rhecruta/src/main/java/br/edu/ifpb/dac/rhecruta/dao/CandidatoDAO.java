package br.edu.ifpb.dac.rhecruta.dao;

import br.edu.ifpb.dac.rhecruta.domain.Candidato;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CandidatoDAO implements DAO<Candidato>{

    private EntityManager em;

    public CandidatoDAO() {
        em = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();
    }

    @Override
    public void salvar(Candidato c){
        em.persist(c);
    }
    @Override
    public Candidato buscar(Candidato c){
        return em.find(Candidato.class,c.getEmail());
    }
    @Override
    public void deletar(Candidato c){
        em.remove(c);
    }
    @Override
    public Candidato atualizar(Candidato c){
        return em.merge(buscar(c));
    }

}
