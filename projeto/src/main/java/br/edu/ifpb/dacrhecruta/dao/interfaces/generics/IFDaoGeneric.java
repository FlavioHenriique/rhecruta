package br.edu.ifpb.dacrhecruta.dao.interfaces.generics;

import java.util.List;

/**
 * Esta interface genérica define as operações semelhantes atribuídas aos objetos
 */
public interface IFDaoGeneric<T> {
    public void salvar(T obj);
    public List<T> buscar();
    public T buscar(T obj);
    public void deletar(T obj);
    public T atualizar(T obj);
}
