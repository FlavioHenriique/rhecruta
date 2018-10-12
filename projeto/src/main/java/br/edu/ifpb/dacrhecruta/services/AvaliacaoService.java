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

    @Override
    public String salvar() {

        avaliacao.setCodVaga(avaliacao.getVaga().getId());
        ELContext el = FacesContext.getCurrentInstance().getELContext();
        candidato = (CandidatoService) FacesContext
                .getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(el, null, "candidatoService");
        avaliacao.setCandidato(candidato.getCandidato());
        resource.salvar(avaliacao);
        return "home.xhtml";
    }

    @Override
    public String buscarAvaliacao() {
        resource.buscar(avaliacao);
        return "home.xhtml";
    }

    @Override
    public String atualizar() {
        resource.atualizar(avaliacao);
        return "home.xhtml";
    }

    @Override
    public String deletar() {
        resource.deletar(avaliacao);
        return "home.xhtml";
    }

    /* Get e Set */
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

}
