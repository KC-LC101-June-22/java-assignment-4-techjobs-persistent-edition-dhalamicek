package org.launchcode.techjobs.persistent.models;



import javax.persistence.Entity;



@Entity
public class Skill extends AbstractEntity {


    private String description;

    public Skill(){
    }

    public Skill(String aDescription) {
        super();
        this.description = aDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}