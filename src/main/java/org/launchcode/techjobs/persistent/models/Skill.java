package org.launchcode.techjobs.persistent.models;



import javax.persistence.Entity;
import javax.validation.constraints.Size;


@Entity
public class Skill extends AbstractEntity {






    @Size(max = 500, message = "Description too long!")
    private String description;


    public Skill(){}

    public Skill (String description){
        super();
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }





}