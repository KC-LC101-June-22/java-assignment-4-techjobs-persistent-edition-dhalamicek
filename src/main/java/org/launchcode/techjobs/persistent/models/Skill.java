package org.launchcode.techjobs.persistent.models;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;



@Entity
public class Skill extends AbstractEntity {

    @ManyToOne
    private Job job;



    @Size(max = 500, message = "Description too long!")
    private String description;
    public Skill (String description){
        this.description = description;
    }

    public Skill(){}

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}