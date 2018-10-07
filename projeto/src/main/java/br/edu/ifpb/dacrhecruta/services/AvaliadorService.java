/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.facade.AvaliadorFacade;
import br.edu.ifpb.dacrhecruta.resource.AvaliadorResource;

/**
 *
 * @author Lestat
 */
public class AvaliadorService implements AvaliadorFacade {
    
    private String json;
    private int id;
    private AvaliadorResource resource = new AvaliadorResource();

    @Override
    public String salvar() {
        resource.salvar(json);
        return "home.xhtml";
    }

    @Override
    public String buscarAvaliador() {
        resource.buscarAvaliador(id);
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
    
}
