package com.daixin.schedule.controllers;

import com.daixin.schedule.data.WorkStationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("workStations")
public class WorkStationController {

    private WorkStationRepository workStationRepository;

    @GetMapping
    public String displayWorkStationIndex(Model model) {
        model.addAttribute("title", "Work Stations");
        return "workStations/index";
    }
}
