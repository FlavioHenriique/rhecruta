package br.edu.ifpb.dac.rhecruta.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

public class Vaga implements Serializable {

    private String cidade;
    private String empresa;
    private String descricao;
    private String titulo;

    public Vaga(String cidade, String empresa, String descricao, String titulo) {
        this.cidade = cidade;
        this.empresa = empresa;
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public Vaga() {
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.cidade);
        hash = 47 * hash + Objects.hashCode(this.empresa);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaga other = (Vaga) obj;
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vaga{" + "cidade=" + cidade + ", empresa="
                + empresa + ", descricao=" + descricao
                + ", titulo=" + titulo + '}';
    }

}
