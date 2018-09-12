package br.edu.ifpb.dac.rhecruta.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Avaliacao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Candidato candidato;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "vaga"))
    private Vaga vaga;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gerente gerente;
    @ManyToOne(cascade = CascadeType.ALL)
    private Avaliador avaliador;
    private float nota;
    private String horario;
    private String local;
    private boolean aprovacao;

    public Avaliacao() {
    }

    public Avaliacao(Candidato candidato, Vaga vaga, Gerente gerente,
                     Avaliador avaliador, float nota, String horario,
                     String local, boolean aprovacao) {
        this.candidato = candidato;
        this.vaga = vaga;
        this.gerente = gerente;
        this.avaliador = avaliador;
        this.nota = nota;
        this.horario = horario;
        this.local = local;
        this.aprovacao = aprovacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
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

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", candidato=" + candidato +
                ", vaga=" + vaga +
                ", gerente=" + gerente +
                ", avaliador=" + avaliador +
                ", nota=" + nota +
                ", horario='" + horario + '\'' +
                ", local='" + local + '\'' +
                ", aprovacao=" + aprovacao +
                '}';
    }
}
