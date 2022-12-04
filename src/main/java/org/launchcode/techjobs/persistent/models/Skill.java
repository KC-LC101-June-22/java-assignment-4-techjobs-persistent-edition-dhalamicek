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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}