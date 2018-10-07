/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.facade.VagaFacade;
import br.edu.ifpb.dacrhecruta.resource.VagaResource;

/**
 *
 * @author Lestat
 */
public class VagaService implements VagaFacade {
    
    private String cidade;
    private String descricao;
    private String empresa;
    private VagaResource resource = new VagaResource();

    @Override
    public String buscaCidade() {
        resource.buscaCidade(cidade);
        return "home.xhtml";
    }

    @Override
    public String buscaDescricao() {
        resource.buscaDescricao(descricao);
        return "home.xhtml";
    }

    @Override
    public String buscaEmpresa() {
        resource.buscaEmpresa(empresa);
        return "home.xhtml";
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
    
}
