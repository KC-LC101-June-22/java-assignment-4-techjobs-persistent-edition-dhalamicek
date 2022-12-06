package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("index")
    public String index(Model model) {
    model.addAttribute("title", "All Jobs");
    model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@RequestParam String jobName) {
//pass in all the parts Employer employer, Skill etc

        return "redirect:";
    }

//            @ModelAttribute @Valid Job newJob,
//                                       Errors errors, Model model) {

//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            jobs.add(new)
//            return "jobs/add";
//        }
//        jobRepository.save(newJob);


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
//
//
//
//
//            Optional optJob = jobRepository.findById(jobId);
//            if (optJob.isPresent()) {
//                Employer employer = (Employer) optJob.get();
//                model.addAttribute("job", "View Job");
//                return "job/view";
//            } else {
//                return "redirect:../";

//            }
        return "view";
    }


}
