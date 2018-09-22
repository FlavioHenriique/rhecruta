package br.edu.ifpb.dacrhecruta.dao.interfaces;

import java.util.List;

/**
 *
 * @author aguirresabino
 */
public interface IFDaoGeneric<T> {
    public void salvar(T obj);
    public List<T> buscar();
    public T buscar(T obj);
    public void deletar(T obj);
    public T atualizar(T obj);
}
