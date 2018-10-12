package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliadorDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import br.edu.ifpb.dacrhecruta.facade.AvaliadorFacade;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AvaliadorService implements AvaliadorFacade, Serializable {

    private Avaliador avaliador = new Avaliador();
    @Inject
    private AvaliadorDaoIF dao;

    @Override
    public String salvar() {
        dao.salvar(avaliador);
        avaliador = new Avaliador();
        return "home.xhtml";
    }

    @Override
    public String buscarAvaliador() {

        return "home.xhtml";
    }

    @Override
    public String atualizar() {
        dao.atualizar(avaliador);
        return "home.xhtml";
    }

    @Override
    public String deletar() {

        return "home.xhtml";
    }

    public String autenticar() {
        avaliador = dao.buscar(avaliador);
        if (avaliador != null) {
            return "avaliador/home.xhtml";
        } else {
            avaliador = new Avaliador();
            return "welcome.xhtml";
        }

    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

}
