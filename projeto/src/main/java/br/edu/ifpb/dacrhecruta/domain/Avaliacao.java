package br.edu.ifpb.dacrhecruta.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float nota;
    private String horario;
    private String local;
    private boolean aprovacao;
    private boolean classificacao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gerente gerente;
    @ManyToOne(cascade = CascadeType.ALL)
    private Avaliador avaliador;
    @OneToOne(cascade = CascadeType.ALL)
    private Candidato candidato;
    private int codVaga;
    @Transient
    private Vaga vaga;

    public Avaliacao() {
    }

    public Avaliacao(float nota, String horario, String local, boolean aprovacao,
            Gerente gerente, Avaliador avaliador, Candidato candidato, int codVaga) {
        this.nota = nota;
        this.horario = horario;
        this.local = local;
        this.aprovacao = aprovacao;
        this.gerente = gerente;
        this.avaliador = avaliador;
        this.candidato = candidato;
        this.codVaga = codVaga;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
        this.aprovacao = (nota >= 7);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public boolean isClassificacao() {
        return classificacao;
    }

    public void setClassificacao(boolean classificacao) {
        this.classificacao = classificacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getCodVaga() {
        return codVaga;
    }

    public void setCodVaga(int codVaga) {
        this.codVaga = codVaga;
    }
}
