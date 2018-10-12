/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.facade.AgendaFacade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named
@RequestScoped
public class AgendaService implements AgendaFacade {
    
    private Avaliacao avaliacao = new Avaliacao();

    @Override
    public String agendar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String agendamentos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* Get e Set */
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
}
