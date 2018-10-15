package br.edu.ifpb.dacrhecruta.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Newsweek implements Serializable {

    @Id
    private String email;

    public Newsweek() {
    }

    public Newsweek(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
