package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import br.edu.ifpb.dacrhecruta.facade.GerenteFacade;
import br.edu.ifpb.dacrhecruta.resource.GerenteResource;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lestat
 */
@Named
@SessionScoped
public class GerenteService implements GerenteFacade, Serializable {

    private Gerente gerente = new Gerente();
    @Inject
    private GerenteDaoIF dao;

    @Override
    public String salvar() {
        dao.salvar(gerente);
        return "gerente/home.xhtml";
    }

    public String buscarGerente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar() {
        gerente = dao.atualizar(gerente);
        return "gerente/home.xhtml";
    }

    @Override
    public String deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String autenticar() {
        System.out.println("entrou");
        gerente = dao.autenticar(gerente.getCodigo());
        if (gerente != null) {
            return "gerente/home.xhtml";
        } else {
            gerente = new Gerente();
            return "welcome.xhtml";
        }
    }

    public String sair() {
        System.out.println("sair");
        gerente = new Gerente();
        return "/welcome.xhtml";
    }
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

}
