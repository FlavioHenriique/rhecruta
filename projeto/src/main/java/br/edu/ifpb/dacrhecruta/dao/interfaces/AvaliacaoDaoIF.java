package br.edu.ifpb.dacrhecruta.dao.interfaces;

import br.edu.ifpb.dacrhecruta.dao.interfaces.generics.IFDaoGeneric;
import br.edu.ifpb.dacrhecruta.domain.Avaliacao;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import java.util.List;

public interface AvaliacaoDaoIF extends IFDaoGeneric<Avaliacao> {

    public List<Avaliacao> buscar(Candidato candidato);
}
