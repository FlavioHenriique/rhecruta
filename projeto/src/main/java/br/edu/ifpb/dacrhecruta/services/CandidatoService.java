/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.facade.CandidatoFacade;
import br.edu.ifpb.dacrhecruta.resource.CandidatoResource;

/**
 *
 * @author Lestat
 */
public class CandidatoService implements CandidatoFacade {
    
    private String json;
    private int id;
    private CandidatoResource resource = new CandidatoResource();

    @Override
    public String autenticar() {
        //resource.autenticar(json);
        return "home.xhtml";
    }

    @Override
    public String salvar() {
        resource.salvar(json);
        return "home.xhtml";
    }

    @Override
    public String buscarCandidato() {
        resource.buscarCandidato(json);
        return "home.xhtml";
    }

    @Override
    public String atualizar() {
        resource.atualizar(json);
        return "home.xhtml";
    }

    @Override
    public String deletar() {
        resource.deletar(json);
        return "home.xhtml";
    }

    /* Get e Set */
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
