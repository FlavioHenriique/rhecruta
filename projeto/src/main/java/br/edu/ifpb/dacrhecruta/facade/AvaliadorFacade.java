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
@Named("avaliador")
public interface AvaliadorFacade {
    
    public String salvar();
    public String buscarAvaliador();
    public String atualizar();
    public String deletar();
    
}
