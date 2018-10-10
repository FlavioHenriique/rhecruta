/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author aguirresabino
 */
@Stateless
public class CandidatoDao implements CandidatoDaoIF {

    @PersistenceContext
    EntityManager em;
    @Inject
    private BuscaPyJobs jobs;

    @Override
    public void salvar(Candidato obj) {
        em.persist(obj);
    }

    @Override
    public List<Candidato> buscar() {
        List<Candidato> candidatos = em.createQuery("SELECT c FROM Candidato c")
                .getResultList();
        return candidatos;
    }

    @Override
    public Candidato buscar(Candidato obj) {
        Candidato candidato = em.find(Candidato.class, obj.getEmail());
        if(candidato!= null){
            candidato.setInteresses(
                jobs.interessesCandidato(candidato.getVagas())
        );
        }
        return candidato;
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
    @Override
    public Candidato autenticar(String email, String senha) {
        Candidato c = new Candidato();
        c.setEmail(email);
        c = buscar(c);
        
        if(c != null && c.getSenha().equals(senha)){
            return c;
        }
        return null;
    }
}
