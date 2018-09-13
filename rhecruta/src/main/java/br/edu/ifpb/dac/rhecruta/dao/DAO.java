package br.edu.ifpb.dac.rhecruta.dao;



public interface DAO<T> {

    public void salvar(T obj);
    public T buscar(T obj);
    public void deletar(T obj);
    public T atualizar(T obj);

}
