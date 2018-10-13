package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import br.edu.ifpb.dacrhecruta.facade.GerenteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@SessionScoped
public class GerenteService implements GerenteFacade, Serializable {

    private Gerente gerente = new Gerente();
    @Inject
    private GerenteDaoIF dao;
    @Inject
    private CandidatoDaoIF daoCandidato;
    private List<Candidato> candidatos;

    @PostConstruct
    public void init() {
        candidatos = new ArrayList<>();
    }

    @Override
    public String salvar() {
        dao.salvar(gerente);
        return "gerente/home.xhtml";
    }

    @Override
    public String buscarGerente() {
        return "";
    }

    @Override
    public String atualizar() {
        gerente = dao.atualizar(gerente);
        return "gerente/home.xhtml";
    }

    @Override
    public String deletar() {
        return "";
    }

    @Override
    public String autenticar() {
        System.out.println("entrou");
        gerente = dao.autenticar(gerente.getCodigo());
        if (gerente != null) {
            return "gerente/home.xhtml";
        } else {
            gerente = new Gerente();
            return "welcome.xhtml";
        }
    }

    public String sair() {
        System.out.println("sair");
        gerente = new Gerente();
        return "/welcome.xhtml";
    }

    public void buscaPorCandidato(String email) {
        candidatos = new ArrayList<>();
        candidatos.add(daoCandidato.buscar(email));
    }

    public void buscaPorVaga(int id){
        candidatos = new ArrayList<>();
        candidatos = daoCandidato.buscaPorVagas(id);
    }
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

}
