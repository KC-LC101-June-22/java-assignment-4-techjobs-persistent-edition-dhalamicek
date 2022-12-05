package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("employers")
public class EmployerController {


    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    JobRepository jobRepository;

    @GetMapping("index")
    public String index(@RequestParam(required = false) Integer jobId, Model model) {

        if (jobId == null) {
            model.addAttribute("title", "All Employers");
            model.addAttribute("employers", employerRepository.findAll());
        } else {
            Optional<Job> result = jobRepository.findById(jobId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Job ID: " + jobId);
            } else {
                Job job = result.get();
                model.addAttribute("title", "Employers: " + job.getName());
                model.addAttribute("employers", job.getEmployer());
            }
        }
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("title", "Add Employer");
        model.addAttribute(new Employer());
        //model.addAttribute("location", employerRepository.findAll());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Employer");
            return "employers/add";
        }
        employerRepository.save(newEmployer);
        return "redirect:";
    }

    @PostMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {


        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", "View Employer");
            return "employers/view";
        } else {
            return "redirect:../";

        }
    }
}





