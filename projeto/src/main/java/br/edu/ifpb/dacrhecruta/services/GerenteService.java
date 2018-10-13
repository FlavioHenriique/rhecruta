package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.AvaliacaoDaoIF;
import br.edu.ifpb.dacrhecruta.dao.interfaces.GerenteDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Gerente;
import br.edu.ifpb.dacrhecruta.facade.GerenteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class GerenteService implements GerenteFacade, Serializable {

    private Gerente gerente = new Gerente();
    @Inject
    private GerenteDaoIF dao;
    @Inject
    private AvaliacaoDaoIF daoAvaliacao;
    private List<Avaliacao> avaliacoes;

    @PostConstruct
    public void init() {
        avaliacoes = new ArrayList<>();
    }

    @Override
    public String salvar() {
        dao.salvar(gerente);
        return "gerente/home.xhtml";
    }

    @Override
    public String buscarGerente() {
        return "";
    }

    @Override
    public String atualizar() {
        gerente = dao.atualizar(gerente);
        return "gerente/home.xhtml";
    }

    @Override
    public String deletar() {
        dao.deletar(gerente);
        return "/welcome.xhtml";
    }

    @Override
    public String autenticar() {
        gerente = dao.autenticar(gerente.getCodigo());
        if (gerente != null) {
            return "gerente/home.xhtml";
        } else {
            gerente = new Gerente();
            return "welcome.xhtml";
        }
    }

    public String sair() {
        gerente = new Gerente();
        return "/welcome.xhtml";
    }

    public void buscaPorCandidato(String email) {
        avaliacoes = new ArrayList<>();
        avaliacoes = daoAvaliacao.buscaPorCandidato(email);

    }

    public void buscaPorVaga(int id) {
        avaliacoes = new ArrayList<>();
        avaliacoes = daoAvaliacao.buscaPorVaga(id);
    }

    public String resultado(Avaliacao avaliacao, boolean classificacao) {
        avaliacao.setClassificacao(classificacao);
        daoAvaliacao.atualizar(avaliacao);
        this.avaliacoes = new ArrayList<>();
        return "gerente/curriculos.xhtml";
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
