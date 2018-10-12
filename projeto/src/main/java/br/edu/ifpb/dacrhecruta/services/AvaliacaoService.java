/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.facade.AvaliacaoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@RequestScoped
public class AvaliacaoService implements AvaliacaoFacade {

    private Avaliacao avaliacao = new Avaliacao();
    @Inject
    private AvaliacaoDaoIF resource;
    @ManagedProperty(value = "#{candidatoService}")
    private CandidatoService candidato;
    private List<Avaliacao> minhasAvaliacoes = new ArrayList<>();

    @PostConstruct
    public void init() {
        ELContext el = FacesContext.getCurrentInstance().getELContext();
        candidato = (CandidatoService) FacesContext
                .getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(el, null, "candidatoService");
        minhasAvaliacoes();
    }

    @Override
    public String salvar() {

        avaliacao.setCodVaga(avaliacao.getVaga().getId());

        avaliacao.setCandidato(candidato.getCandidato());
        resource.salvar(avaliacao);
        minhasAvaliacoes();
        return "horario.xhtml";
    }

    @Override
    public String buscarAvaliacao() {
        resource.buscar(avaliacao);
        return "horario.xhtml";
    }

    @Override
    public String atualizar() {
        resource.atualizar(avaliacao);
        return "horario.xhtml";
    }

    public void minhasAvaliacoes() {
        minhasAvaliacoes = resource.buscar(candidato.getCandidato());
    }

    @Override
    public String deletar(Avaliacao avaliacao) {
        resource.deletar(avaliacao);
        minhasAvaliacoes();
        return "horario.xhtml";
    }

    /* Get e Set */
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getMinhasAvaliacoes() {
        return minhasAvaliacoes;
    }

    public void setMinhasAvaliacoes(List<Avaliacao> minhasAvaliacoes) {
        this.minhasAvaliacoes = minhasAvaliacoes;
    }

}
