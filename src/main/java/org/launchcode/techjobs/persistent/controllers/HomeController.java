package org.launchcode.techjobs.persistent.controllers;

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

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("")
public class HomeController {
private static List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;



    @GetMapping("index")
    public String index(Model model) {
model.addAttribute("title", "All Jobs");
model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employer", employerRepository.findAll());
        model.addAttribute("skill", skillRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@RequestParam String jobName) {

        jobs.add(new Job());
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

        return "view";
    }


}
