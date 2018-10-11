/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.facade;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author JuliermeH
 */
@Named("vaga")
public interface VagaFacade {
    
    public void buscaCidade();
    public void buscaDescricao();
    public void buscaEmpresa();
    
}
