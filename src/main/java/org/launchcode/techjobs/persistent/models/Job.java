package org.launchcode.techjobs.persistent.models;

import org.springframework.ui.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Job extends AbstractEntity {

//    @ManyToOne
//    @JoinColumn(name = "employer_id")
    @Transient
    @NotNull
    private Employer employer = new Employer();

    public static List<Skill> skills = new ArrayList<>();

    public static List<Skill> getSkills() {
        return skills;
    }

    public static void setSkills(List<Skill> skills) {
        Job.skills = skills;
    }

    public Job() {};
    public Job (Employer employer, String location, Model model) {

        model.addAttribute("location", location);

        model.addAttribute(skills);
        model.addAttribute("description", skills);
    }

    public Employer getEmployer () {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}













