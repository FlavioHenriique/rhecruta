package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AvaliacaoDao implements AvaliacaoDaoIF {

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
        return em.find(Avaliacao.class,obj.getId());
    }

    @Override
    public void deletar(Avaliacao obj) {
        em.remove(obj);
    }

    @Override
    public Avaliacao atualizar(Avaliacao obj) {
        em.merge(obj);
        return this.buscar(obj);
    }
}
