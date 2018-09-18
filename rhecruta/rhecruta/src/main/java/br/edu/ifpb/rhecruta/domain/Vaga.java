package br.edu.ifpb.rhecruta.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class Vaga implements Serializable {

    private int id;
    private String workplace;
    private String company_name;
    private String description;
    private String title;
    private String requirements;

    public Vaga(){

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
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", workplace='" + workplace + '\'' +
                ", company_name='" + company_name + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", requirements='" + requirements + '\'' +
                '}';
    }
}

