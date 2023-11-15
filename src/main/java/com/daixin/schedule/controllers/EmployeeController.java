package com.daixin.schedule.controllers;

import com.daixin.schedule.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployeeIndex(Model model) {
        model.addAttribute("title", "Employee Main");
        return "employees/index";
    }
}
