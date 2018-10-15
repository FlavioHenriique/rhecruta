/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import br.edu.ifpb.dacrhecruta.facade.VagaFacade;
import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@ViewScoped
public class VagaService implements VagaFacade, Serializable {

    private String cidade;
    private String descricao;
    private String empresa;
    @Inject
    private BuscaPyJobs jobs;
    private List<Vaga> vagas;

    @PostConstruct
    public void init() {
        vagas = new ArrayList<>();
    }

    @Override
    public void buscaCidade() {
        vagas = jobs.buscaCidade(cidade);

    }

    @Override
    public void buscaDescricao() {
        vagas = jobs.buscaDescricao(descricao);
    }

    @Override
    public void buscaEmpresa() {
        vagas = jobs.buscaEmpresa(empresa);
    }

    /* Get e Set */
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

}
