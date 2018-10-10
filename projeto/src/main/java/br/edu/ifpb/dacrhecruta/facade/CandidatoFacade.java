/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.facade;

import javax.inject.Named;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author JuliermeH
 */
@Named("candidato")
public interface CandidatoFacade {
    
    public String autenticar();
    public String salvar();
    public String buscarCandidato();
    public String atualizar();
    public String deletar();
        
}
