package br.edu.ifpb.dacrhecruta.dao;

public interface DAO<T> {

    public void salvar(T obj);

    public T buscar(Object obj);

    public void deletar(T obj);

    public T atualizar(T obj);
}
