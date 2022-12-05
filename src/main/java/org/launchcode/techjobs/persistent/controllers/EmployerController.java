package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
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

    @GetMapping("index")
    public String index (Model model) {
        model.addAttribute("title", "All Employers");
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("title", "Add Employer");
        model.addAttribute(new Employer());
        model.addAttribute("location", employerRepository.findAll());
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
    public String displayViewEmployer(@RequestParam(required = false) Integer employerId, Model model) {

        if (employerId != null) {
            model.addAttribute("title", "Employer");
            model.addAttribute("employer", employerRepository.findById(employerId));

        } else {
            Optional<Employer> result = employerRepository.findById(employerId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Employer ID: " + (employerId));
            } else {
                Employer employer = result.get();
                model.addAttribute("title", "Employer: " + (employer.getName()));
            }
        }
        return "view/{employerId}";
    }
}




