package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Employer extends AbstractEntity {



    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();


    @NotBlank
    @Size(min = 3, message = "Location must contain at least three characters")
    private String location;

    public Employer(String location) {

        this.location = location;
    }

    public Employer() {
    }

    public String getLocation() {
        return location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}




