package br.edu.ifpb.dac.rhecruta.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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
        return "Gerente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
