package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
public class Job extends AbstractEntity{

    @OneToOne
    @NotNull(message = "Employer is required")
    private Employer employer;
    @OneToMany
    private Skill skill;






    public Job(Employer employer, Skill skill) {
        super();
        this.employer = employer;
        this.skill = skill;
    }

    public Job() {
    }

    // Getters and setters.


    @Override
    public String toString() {
        return "Job{" +
                "employer=" + employer +
                ", skill=" + skill +
                '}';
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
