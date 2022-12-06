package org.launchcode.techjobs.persistent.models;


import javax.persistence.*;


import java.util.List;


@Entity
public class Job extends AbstractEntity {

@ManyToOne
   private Employer employer;

@ManyToMany
    private List<Skill> skills;

    public Job() {};
    public Job (Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Employer getEmployer () {
        return this.employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


}









