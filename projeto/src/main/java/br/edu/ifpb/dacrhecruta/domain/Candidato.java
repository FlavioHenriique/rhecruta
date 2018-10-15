package br.edu.ifpb.dacrhecruta.domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.StreamedContent;

@Entity
public class Candidato implements Serializable {

    @Id
    private String email;
    private String senha;
    private String curriculo;
    @Transient
    private StreamedContent content;
    private String nome;
    
    @ElementCollection
    private List<Integer> vagas;
    @Transient
    private List<Vaga> interesses;

    public Candidato(String curriculo, String nome,
            String email, String senha) {
        this.curriculo = curriculo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        interesses = new ArrayList<>();
        vagas = new ArrayList<>();
    }

    public Candidato() {
        interesses = new ArrayList<>();
        vagas = new ArrayList<>();
    }

    public List<Integer> getVagas() {
        return vagas;
    }

    public void setVagas(List<Integer> vagas) {
        this.vagas = vagas;
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

    public void removerInteresse(Vaga v) {
        for (int k = 0; k < vagas.size(); k++) {
            if (vagas.get(k) == v.getId()) {
                vagas.remove(k);
            }
        }
    }

    public void adicionarInteresse(Vaga v) {
        interesses.add(v);
        vagas.add(v.getId());
    }

    public List<Vaga> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Vaga> interesses) {
        this.interesses = interesses;
    }

    public StreamedContent getContent() {
        return content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Candidato{"
                + "email=" + email
                + ", senha=" + senha
                + ", curriculo=" + curriculo
                + ", nome=" + nome
                + ", vagas=" + vagas
                + ", interesses="
                + interesses + '}';
    }

}
