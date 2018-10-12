/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.facade;

import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named("avaliacao")
public interface AvaliacaoFacade {
    
    public String salvar();
    public String buscarAvaliacao();
    public String atualizar();
    public String deletar(Avaliacao avaliacao);
    
}
