package br.edu.ifpb.dacrhecruta.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avaliador implements Serializable {

    @Id
    private int codigo;
    private String nome;

    public Avaliador() {

    }

    public Avaliador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Gerente{"
                + "codigo=" + codigo
                + ", nome='" + nome + '\''
                + '}';
    }
}
