/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.facade;

import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named("vaga")
public interface VagaFacade {
    
    public String buscaCidade();
    public String buscaDescricao();
    public String buscaEmpresa();
    
}
