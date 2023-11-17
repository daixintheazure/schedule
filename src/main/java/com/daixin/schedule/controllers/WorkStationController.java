package com.daixin.schedule.controllers;

import com.daixin.schedule.data.WorkStationRepository;
import com.daixin.schedule.models.Employee;
import com.daixin.schedule.models.WorkStation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("workStations")
public class WorkStationController {

    @Autowired
    private WorkStationRepository workStationRepository;

    @GetMapping
    public String displayWorkStationIndex(Model model) {
        model.addAttribute("title", "Work Stations");
        model.addAttribute("workStations", workStationRepository.findAll());
        return "workStations/index";
    }

    @GetMapping("add")
    public String displayAddWorkStation(Model model) {
        model.addAttribute("title", "Create Station");
        model.addAttribute(new WorkStation());

        return "workStations/add";
    }

    @PostMapping("add")
    public String processingAddWorkStationForm(@ModelAttribute @Valid WorkStation newWorkStation,
                                            Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Work Station");
            return "workStations/add";
        }

        workStationRepository.save(newWorkStation);
        return "redirect:/workStations";
    }
}

