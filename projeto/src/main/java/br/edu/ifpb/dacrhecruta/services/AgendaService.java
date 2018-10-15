/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AgendaDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.facade.AgendaFacade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@RequestScoped
public class AgendaService implements AgendaFacade {
    
    private Avaliacao avaliacao = new Avaliacao();
    @Inject
    private AgendaDaoIF resource;

    @Override
    public String agendar() {
        resource.salvar(avaliacao);
        return "home.xhtml";
    }

    @Override
    public String agendamentos() {
        resource.buscar();
        return "home.xhtml";
    }

    @Override
    public String cancelar() {
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
