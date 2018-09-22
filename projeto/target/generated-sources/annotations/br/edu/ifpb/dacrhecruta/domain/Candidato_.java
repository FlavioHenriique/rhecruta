package br.edu.ifpb.dacrhecruta.domain;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-22T08:45:15")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, String> senha;
    public static volatile ListAttribute<Candidato, Vaga> interesses;
    public static volatile SingularAttribute<Candidato, String> curriculo;
    public static volatile SingularAttribute<Candidato, String> nome;
    public static volatile SingularAttribute<Candidato, String> email;

}