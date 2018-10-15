/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aguirresabino
 */
@Stateless
public class GerenteDao implements GerenteDaoIF {

    @PersistenceContext
    EntityManager em;

    @Override
    public void salvar(Gerente obj) {
        em.persist(obj);
    }

    @Override
    public List<Gerente> buscar() {
        List<Gerente> gerentes = em.createQuery("SELECT g FROM Gerente").getResultList();
        return gerentes;
    }

    @Override
    public Gerente buscar(Gerente obj) {
        return em.find(Gerente.class, obj.getCodigo());
    }

    @Override
    public void deletar(Gerente obj) {
        em.remove(buscar(obj));
    }

    @Override
    public Gerente atualizar(Gerente obj) {
        em.merge(obj);
        return this.buscar(obj);
    }

    @Override
    public Gerente autenticar(int codigo) {
        return em.find(Gerente.class, codigo);
    }
}
