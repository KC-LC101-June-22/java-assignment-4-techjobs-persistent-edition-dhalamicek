package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Job extends AbstractEntity{

   @OneToMany(mappedBy =  "job")
    private final List<Skill> skills = new ArrayList<>();

    public Job(Employer employer, Skill skill) {

        this.employer = employer;
        this.skill = skill;

    }


    public Job(){}

    public List<Skill> getSkills() {
        return skills;
    }

    @OneToOne
    @NotNull(message = "Employer is required")
    private Employer employer;



    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


}
