package br.edu.ifpb.dac.rhecruta.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Avaliacao implements Serializable{
    
    @ManyToOne
    private Candidato candidato;
    private float nota;
    private String horario;
    private String local;
    private boolean aprovacao;
    @Transient
    private Vaga vaga;

    public Avaliacao() {
    }

    
    
    
    
}
