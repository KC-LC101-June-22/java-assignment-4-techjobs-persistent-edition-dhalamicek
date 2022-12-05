package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class Employer extends AbstractEntity {


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NotBlank
    @Size(min = 3, message = "Location must contain at least three characters")
    private String location;

    public Employer() {
    }

    public Employer(String location) {

        this.location = location;
    }

    @Override
    public String toString(){
        return location;
    }
}




