/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aguirresabino
 */
@Stateless
public class GerenteDao implements GerenteDaoIF, Serializable{
    
    @PersistenceContext
    EntityManager em;

    public void salvar(Gerente obj) {
        em.persist(obj);
    }

    public List<Gerente> buscar() {
        List<Gerente> gerentes = em.createQuery("SELECT g FROM Gerente").getResultList();
        return gerentes;
    }

    public Gerente buscar(Gerente obj) {
        return em.find(Gerente.class, obj.getCodigo());
    }

    public void deletar(Gerente obj) {
        em.remove(obj);
    }

    public Gerente atualizar(Gerente obj) {
        em.merge(obj);
        return this.buscar(obj);
    }
    
}
