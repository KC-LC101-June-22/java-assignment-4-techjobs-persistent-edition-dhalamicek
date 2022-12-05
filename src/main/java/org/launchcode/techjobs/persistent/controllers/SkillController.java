package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.launchcode.techjobs.persistent.models.dto.JobSkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("skills")
public class SkillController {


    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("index")
    public String index(@RequestParam(required = false) Integer jobId, Model model) {

        if (jobId == null) {
            model.addAttribute("title", "All Skills");
            model.addAttribute("skills", skillRepository.findAll());

        } else {
            Optional<Job> result = jobRepository.findById(jobId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Job ID: " + jobId);
            } else {
                Job job = result.get();
                model.addAttribute("title", "Skills in job: " + job.getName());
                model.addAttribute("skills", job.getSkills());
            }
        }
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("title", "Add Skill");
        model.addAttribute(new Skill());
        //model.addAttribute("description", skillRepository.findAll());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @PostMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {


        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Employer employer = (Employer) optSkill.get();
            model.addAttribute("skill", "View Skill");
            return "skills/view";
        } else {
            return "redirect:../";

        }

    }
}




