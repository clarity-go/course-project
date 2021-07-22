package edu.kashp.controller.gui;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeGuiController
  @version  1.0.0 
  @since 20.07.2021 - 19.42
*/

import edu.kashp.model.Employee;
import edu.kashp.service.employee.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gui/employee")

public class EmployeeGuiController {

    @Autowired
    EmployeeServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){

        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);

        return "employees";
    }
}