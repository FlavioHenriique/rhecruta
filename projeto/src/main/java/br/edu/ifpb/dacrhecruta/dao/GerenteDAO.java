package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.domain.Gerente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GerenteDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Gerente gerente) {

        em.persist(gerente);
    }

    public Gerente buscar(int codigo) {
        return em.find(Gerente.class, codigo);
    }

    public void deletar(Gerente gerente) {

        em.remove(gerente);

    }

    public Gerente atualizar(Gerente gerente) {

        em.merge(gerente);
        return buscar(gerente.getCodigo());
    }
}
