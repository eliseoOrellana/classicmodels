package io.eliseoorellana.classicmodels.Controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import io.eliseoorellana.classicmodels.Service.EmployeeService;

import io.eliseoorellana.classicmodels.model.Employee;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
    
    @GetMapping
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", new Employee());
        return "employees";
    }
    
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }
    @PostMapping("/add")
    public String saveEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.saveOrUpdate(employee);
        redirectAttributes.addFlashAttribute("message", "Employee saved successfully!");
        return "redirect:/employees";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable("id") int id, Employee employee, RedirectAttributes redirectAttributes) {
        employee.setEmployeeNumber(id) ;   
        employeeService.saveOrUpdate(employee);
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{employeeNumber}")
    public String deleteEmployee(@PathVariable("employeeNumber") Integer employeeNumber) {
        employeeService.deleteEmployee(employeeNumber);
        return "redirect:/employees";
    }

    @GetMapping("/soft-delete/{employeeNumber}")
    public String softDeleteEmployee(@PathVariable("employeeNumber") Integer employeeNumber) {
        employeeService.softDeleteEmployee(employeeNumber);
        return "redirect:/employees";
    }

    

    
}
