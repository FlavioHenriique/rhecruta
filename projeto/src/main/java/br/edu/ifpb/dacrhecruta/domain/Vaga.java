package br.edu.ifpb.dacrhecruta.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Vaga implements Serializable {

    private int id;
    @Transient
    private String workplace;
    @Transient
    private String company_name;
    @Transient
    private String description;
    @Transient
    private String title;
    @Transient
    private String requirements;

    public Vaga() {

    }

    public Vaga(int id, String workplace, String company_name,
            String description, String title, String requirements) {
        this.id = id;
        this.workplace = workplace;
        this.company_name = company_name;
        this.description = description;
        this.title = title;
        this.requirements = requirements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.workplace);
        hash = 37 * hash + Objects.hashCode(this.company_name);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.requirements);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaga other = (Vaga) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.workplace, other.workplace)) {
            return false;
        }
        if (!Objects.equals(this.company_name, other.company_name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.requirements, other.requirements)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Vaga{"
                + "id=" + id
                + ", workplace='" + workplace + '\''
                + ", company_name='" + company_name + '\''
                + ", description='" + description + '\''
                + ", title='" + title + '\''
                + ", requirements='" + requirements + '\''
                + '}';
    }
}
