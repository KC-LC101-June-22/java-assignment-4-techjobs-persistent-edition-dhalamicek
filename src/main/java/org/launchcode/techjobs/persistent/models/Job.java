package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;



@Entity
public class Job extends AbstractEntity{


    private String employer;


    private String skill;

    //public Job() {    }

    public Job() {
    }

    public Job(String name, String anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
        this.skill = someSkills;}

    // Getters and setters.

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
//public String getName() {
        //return name;}

    //public void setName(String name) {
        //this.name = name;}


}
