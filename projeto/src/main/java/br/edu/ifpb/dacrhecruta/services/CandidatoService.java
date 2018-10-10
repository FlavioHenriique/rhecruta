/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.facade.CandidatoFacade;
import br.edu.ifpb.dacrhecruta.resource.CandidatoResource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lestat
 */
@Named
@RequestScoped
public class CandidatoService implements CandidatoFacade {

    private Candidato candidato = new Candidato();
    @Inject
    private CandidatoDaoIF dao;

    @Override
    public String autenticar() {
        if (dao.autenticar(candidato.getEmail(), candidato.getSenha()) != null) {
            return "home.xhtml";
        } else {
            return "welcome.xhtml";
        }
    }

    @Override
    public String salvar() {
        dao.salvar(candidato);
        return "home.xhtml";
    }

    @Override
    public String buscarCandidato() {
        dao.buscar(candidato);
        return "home.xhtml";
    }

    @Override
    public String atualizar() {
        dao.atualizar(candidato);
        return "home.xhtml";
    }

    @Override
    public String deletar() {
        dao.deletar(candidato);
        return "home.xhtml";
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

}
