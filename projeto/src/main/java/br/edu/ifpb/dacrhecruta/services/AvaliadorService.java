package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliadorDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import br.edu.ifpb.dacrhecruta.domain.Avaliador;
import br.edu.ifpb.dacrhecruta.facade.AvaliadorFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AvaliadorService implements AvaliadorFacade, Serializable {

    private Avaliador avaliador = new Avaliador();
    @Inject
    private AvaliadorDaoIF dao;
    @Inject
    AvaliacaoDaoIF avaliacao;
    private List<Avaliacao> buscaAvaliacoes;

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
        avaliador = dao.atualizar(avaliador);
        return "home.xhtml";
    }

    @Override
    public String deletar() {

        return "home.xhtml";
    }

    public String cancelarAvaliacao(Avaliacao avaliacao) {
        this.avaliacao.deletar(avaliacao);
        this.buscaAvaliacoes = new ArrayList<>();
        return "/faces/avaliador/avaliacoes.xhtml";
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

    public void darNota(String nota, Avaliacao avaliacao) {
        avaliacao.setNota(Float.parseFloat(nota));
        avaliacao.setAvaliador(avaliador);
        this.avaliacao.atualizar(avaliacao);
    }

    public String sair() {

        avaliador = new Avaliador();
        return "/welcome.xhtml";
    }

    public void buscaPorVaga(int id) {
        buscaAvaliacoes = avaliacao.buscaPorVaga(id);
    }

    public void buscaPorCandidato(String email) {
        this.buscaAvaliacoes = avaliacao.buscaPorCandidato(email);
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public List<Avaliacao> getBuscaAvaliacoes() {
        return buscaAvaliacoes;
    }

    public void setBuscaAvaliacoes(List<Avaliacao> buscaAvaliacoes) {
        this.buscaAvaliacoes = buscaAvaliacoes;
    }

}
