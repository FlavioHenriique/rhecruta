/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AgendaDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuliermeH
 */
@Stateless
public class AgendaDao implements AgendaDaoIF {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Avaliacao obj) {
        em.persist(obj);
    }

    @Override
    public List<Avaliacao> buscar() {
        return em
                .createQuery("Select a FROM Avaliacao a",Avaliacao.class)
                .getResultList();
    }

    @Override
    public Avaliacao buscar(Avaliacao obj) {
        return null;
    }

    @Override
    public void deletar(Avaliacao obj) {
        em.remove(obj);
    }

    @Override
    public Avaliacao atualizar(Avaliacao obj) {
        return null;
    }
    
}
