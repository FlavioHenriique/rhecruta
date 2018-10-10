/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.dao.interfaces;

import br.edu.ifpb.dacrhecruta.dao.interfaces.generics.IFDaoGeneric;
import br.edu.ifpb.dacrhecruta.domain.Gerente;

/**
 *
 * @author aguirresabino
 */
public interface GerenteDaoIF extends IFDaoGeneric<Gerente>{
    Gerente autenticar(int codigo);
}
