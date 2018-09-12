package br.edu.ifpb.dac.rhecruta.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Vaga implements Serializable {

    private int id;
    private String workplace;
    private String company_name;
    private String description;
    private String title;
    private String requirements;
    
    
    
}
