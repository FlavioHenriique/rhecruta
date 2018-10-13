/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao.interfaces;

import br.edu.ifpb.dacrhecruta.dao.interfaces.generics.IFDaoGeneric;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import java.util.List;

/**
 *
 * @author aguirresabino
 */
public interface CandidatoDaoIF extends IFDaoGeneric<Candidato>{
    Candidato autenticar(String email, String senha);
    Candidato buscar(String email);
    public List<Candidato> buscaPorVagas(int id) ;
}
