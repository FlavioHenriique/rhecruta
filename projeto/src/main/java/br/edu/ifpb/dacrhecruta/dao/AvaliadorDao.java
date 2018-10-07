/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliadorDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AvaliadorDao implements AvaliadorDaoIF{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Avaliador obj) {
        em.persist(obj);
    }

    @Override
    public List<Avaliador> buscar() {
        List<Avaliador> avaliadores = em.createQuery("SELECT a FROM Avaliador").getResultList();
        return avaliadores;
    }

    @Override
    public Avaliador buscar(Avaliador obj) {
        return em.find(Avaliador.class, obj.getCodigo());
    }

    @Override
    public void deletar(Avaliador obj) {
        em.remove(obj);
    }

    @Override
    public Avaliador atualizar(Avaliador obj) {
        em.merge(obj);
        return this.buscar(obj);
    }
    
}
