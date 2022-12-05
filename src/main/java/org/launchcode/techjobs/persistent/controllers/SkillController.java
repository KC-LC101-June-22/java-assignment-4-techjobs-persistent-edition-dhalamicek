package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
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
    JobRepository jobRepository;

    @GetMapping("index")
    public String index (@RequestParam(required = false) Integer jobId, Model model){

        if (jobId == null) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    } else {
           jobRepository.findById(jobId);
        }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        //model.addAttribute("title", "Add Skill");
        model.addAttribute(new Skill());
        model.addAttribute("description", skillRepository.findAll());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model ) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @PostMapping("view/{skillId}")
    public String displayViewSkill(@RequestParam(required = false) Integer skillId, Model model) {
        if (skillId != null) {
            model.addAttribute("title", "Skill");
            model.addAttribute("skill", skillRepository.findById(skillId));

        } else {
            Optional<Skill> result = skillRepository.findById(skillId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Skill ID: " + (skillId));
            } else {
                Skill skill = result.get();
                model.addAttribute("title", "Skill: " + (skill.getName()));
            }
        }
        return "view/{skillId}";
    }


}
