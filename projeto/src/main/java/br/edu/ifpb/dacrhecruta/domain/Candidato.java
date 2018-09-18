package br.edu.ifpb.dacrhecruta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Candidato implements Serializable {

    @Id
    private String email;
    private String senha;
    private String curriculo;
    private String nome;
    @ElementCollection
    //@CollectionTable(name = "Interesses", joinColumns = @JoinColumn(name = "idVaga"))
    @AttributeOverride(name = "id", column = @Column(name = "idvaga"))
    private List<Vaga> interesses;

    public Candidato() {
    }

    public Candidato(String curriculo, String nome,
            String email, String senha) {
        this.curriculo = curriculo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        interesses = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vaga> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Vaga> interesses) {
        this.interesses = interesses;
    }

    public void adicionarInteresse(Vaga vaga) {
        this.interesses.add(vaga);
    }

    @Override
    public String toString() {
        return "Candidato{"
                + "email='" + email + '\''
                + ", senha='" + senha + '\''
                + ", curriculo='" + curriculo + '\''
                + ", nome='" + nome + '\''
                + ", interesses=" + interesses
                + '}';
    }
}
