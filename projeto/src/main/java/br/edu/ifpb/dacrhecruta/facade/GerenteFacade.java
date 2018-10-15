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
@Named("gerente")
public interface GerenteFacade {
    
    public String salvar();
    public String buscarGerente();
    public String atualizar();
    public String deletar();
    public String autenticar();
}
