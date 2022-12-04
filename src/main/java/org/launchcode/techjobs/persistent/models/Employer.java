package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min = 3, message = "Location must contain at least 3 characters.")
    private String location;



    public Employer(String aLocation) {
        super();
        this.location = aLocation;
    }



    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
