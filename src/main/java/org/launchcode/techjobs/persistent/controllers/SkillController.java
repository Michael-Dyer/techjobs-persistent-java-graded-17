package org.launchcode.techjobs.persistent.controllers;


import jakarta.validation.Valid;

import org.launchcode.techjobs.persistent.models.Skill;

import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {


    @Autowired
    private SkillRepository skillrepository;


    @GetMapping(value="")
    public String index(Model model){


        //model.addAttribute("title","All Skills");
        model.addAttribute("skills", skillrepository.findAll());

        return "skills/index";
    }


@GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }

        //saves employer from employer repository
        skillrepository.save(newSkill);
        //return "redirect:";
        return "redirect:/skills";

    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional<Skill> optSkill = skillrepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }


}
