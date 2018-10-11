package br.edu.ifpb.dacrhecruta.services;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.domain.Vaga;
import br.edu.ifpb.dacrhecruta.facade.CandidatoFacade;
import br.edu.ifpb.dacrhecruta.resource.CandidatoResource;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lestat
 */
@Named
@SessionScoped
public class CandidatoService implements CandidatoFacade, Serializable {

    private Candidato candidato = new Candidato();
    @Inject
    private CandidatoDaoIF dao;

    @Override
    public String autenticar() {
        if (dao.autenticar(candidato.getEmail(), candidato.getSenha()) != null) {
            candidato = dao.buscar(candidato);
            return "home.xhtml";
        } else {
            candidato = new Candidato();
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
        candidato = dao.atualizar(candidato);
        return "home.xhtml";
    }

    @Override
    public String deletar() {
        dao.deletar(candidato);
        return "home.xhtml";
    }

    public void adicionarInteresse(Vaga interesse){
        System.out.println("adicionar");
        candidato.adicionarInteresse(interesse);
        candidato = dao.atualizar(candidato);
     //   return "vagas.xhtml";
    }
    
    public void removerInteresse(Vaga interesse){
        
        this.candidato.removerInteresse(interesse);
        candidato = dao.atualizar(candidato);
    }
    
    public String sair() {
        System.out.println("sair");
        candidato = new Candidato();
        return "welcome.xhtml";
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

}
