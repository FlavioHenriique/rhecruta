/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.facade.AvaliacaoFacade;
import br.edu.ifpb.dacrhecruta.resource.AvaliacaoResource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@RequestScoped
public class AvaliacaoService implements AvaliacaoFacade {
    
    private String json;
    private int id;
    private AvaliacaoResource resource = new AvaliacaoResource();

    @Override
    public String salvar() {
        resource.salvar(json);
        return "home.xhtml";
    }

    @Override
    public String buscarAvaliacao() {
        resource.buscarAvaliacao(id);
        return "home.xhtml";
    }

    @Override
    public String atualizar() {
        resource.atualizar(json);
        return "home.xhtml";
    }

    @Override
    public String deletar() {
        resource.deletar(id);
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
