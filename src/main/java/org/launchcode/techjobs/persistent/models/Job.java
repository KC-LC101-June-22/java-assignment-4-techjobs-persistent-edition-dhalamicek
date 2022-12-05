package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;



@Entity
public class Job extends AbstractEntity {

    private String employer;



    private String skill;


    public Job() {
    }

    public Job(String jobName) {
        super();
        this.jobName = jobName;
//        this.employer = employer;
//        this.skill = skill;

    }




    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

public String getSkills(){
    return skills;
        }

        public void setSkills(String skills){
        this.skills=skills;
        }

//    @Override
//    public String toString() {
//        return "Job{" +
//                "employer='" + employer + '\'' +
//                ", skills='" + skills + '\'' +
//                '}';
//    }
@Override
public boolean equals(Object o) {
    return super.equals(o);
}
}

