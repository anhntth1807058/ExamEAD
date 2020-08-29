package com.anhnt.controller;

import com.anhnt.entity.EmployeeEntity;
import com.anhnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/addemployee")
    public String openAddEmployee(Model model) {
        EmployeeEntity employee = new EmployeeEntity();
        model.addAttribute("employee", employee);
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String createEmployee(@ModelAttribute EmployeeEntity employee) {
        employeeService.saveEmployee(employee);
        return "listemployee";
    }

    @GetMapping({"/listemployee", "/"})
    public String findAllEmployees(Model model) {
        List<EmployeeEntity> list = employeeService.getAll();
        model.addAttribute("employees", list);
        return "listemployee";
    }
}
