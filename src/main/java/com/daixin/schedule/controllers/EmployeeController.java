package com.daixin.schedule.controllers;

import com.daixin.schedule.data.EmployeeRepository;
import com.daixin.schedule.data.WorkStationRepository;
import com.daixin.schedule.models.Employee;
import com.daixin.schedule.models.WorkStation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WorkStationRepository workStationRepository;

    @GetMapping
    public String displayEmployeeIndex(Model model) {
        model.addAttribute("title", "Employee Main");
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees/index";
    }

    @GetMapping("add")
    public String displayAddEmployee(Model model) {
        model.addAttribute("title", "Create Employee");
        model.addAttribute("workStations", workStationRepository.findAll());
        model.addAttribute(new Employee());

        return "employees/add";
    }

    @PostMapping("add")
    public String processingAddEmployeeForm(@ModelAttribute @Valid Employee newEmployee,
                                            Errors errors, Model model, @RequestParam List<Integer> workstation) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Employee");
            return "employees/add";
        }


        List<WorkStation> workStationObject = (List<WorkStation>) workStationRepository.findAllById(workstation);
        newEmployee.setWorkStation(workStationObject);
        model.addAttribute("workstation", workStationObject);

        employeeRepository.save(newEmployee);
        return "redirect:/employees";
    }

    @GetMapping("edit/{employeeId}")
    public String displayEmployeeEditForm(Model model, @PathVariable int employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()){
            Employee employee = (Employee) optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "employees/edit";
        }
        return "employees/edit";
    }
}
