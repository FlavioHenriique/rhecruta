/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aguirresabino
 */
@Stateless
public class CandidatoDao implements CandidatoDaoIF{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void salvar(Candidato obj) {
        em.persist(obj);
    }

    @Override
    public List<Candidato> buscar() {
        List<Candidato> candidatos = em.createQuery("SELECT c FROM Candidato").getResultList();
        return candidatos;        
    }

    @Override
    public Candidato buscar(Candidato obj) {
        return em.find(Candidato.class, obj.getEmail());
    }

    @Override
    public void deletar(Candidato obj) {
        em.remove(obj);
    }

    @Override
    public Candidato atualizar(Candidato obj) {
        em.merge(obj);
        return this.buscar(obj);
    }
    
}
