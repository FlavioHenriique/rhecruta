/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.facade.GerenteFacade;
import br.edu.ifpb.dacrhecruta.resource.GerenteResource;

/**
 *
 * @author Lestat
 */
public class GerenteService implements GerenteFacade {
    
    private String json;
    private int id;
    private GerenteResource resource = new GerenteResource();

    @Override
    public String salvar() {
        resource.salvar(json);
        return "home.xhtml";
    }

    @Override
    public String buscarGerente() {
        resource.buscarGerente(id);
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
