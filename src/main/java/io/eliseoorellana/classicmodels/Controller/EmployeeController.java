package io.eliseoorellana.classicmodels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.eliseoorellana.classicmodels.model.Employee;
import io.eliseoorellana.classicmodels.service.EmployeeService;
import io.eliseoorellana.classicmodels.service.OfficeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final OfficeService officeService;

    public EmployeeController(EmployeeService employeeService, OfficeService officeService) {
        this.employeeService = employeeService;
        this.officeService = officeService;
    }

    // @Autowired
    // private EmployeeService employeeService; tenia la inyeccion mediante etiqueta autowired pero saonarLite recomiendo inyeccion mediante constructor
    

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);

        // envio de datos para tener el nombre del suvervisor
        String supervisorName = employeeService.getSupervisorName(employee.getReportsTo());
        model.addAttribute("supervisorName", supervisorName);

        return "employee-detail";
    }

    // envio datos para los select
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.getAllEmployees()); // Lista de empleados y cargos
        model.addAttribute("officeCodes", officeService.getAllOffices()); // Lista de códigos de oficina con país y
        model.addAttribute("distinctJobTitles", employeeService.findDistinctJobTitles());

        return "add";
    }

    @PostMapping("/add")
    public String saveEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.saveOrUpdate(employee);
        redirectAttributes.addFlashAttribute("message", "Employee saved successfully!");
        return "redirect:/employees";

    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("officeCodes", officeService.getAllOffices());
        model.addAttribute("distinctJobTitles", employeeService.findDistinctJobTitles());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Employee employee, RedirectAttributes redirectAttributes) {
        employee.setEmployeeNumber(id);
        employeeService.saveOrUpdate(employee);
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{employeeNumber}")
    public String deleteEmployee(@PathVariable("employeeNumber") Integer employeeNumber,
            RedirectAttributes redirectAttributes) {
        try {
            employeeService.deleteEmployee(employeeNumber);
            redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while deleting the employee.");
        }
        return "redirect:/employees";
    }

    @GetMapping("/soft-delete/{employeeNumber}")
    public String softDeleteEmployee(@PathVariable("employeeNumber") Integer employeeNumber,
            RedirectAttributes redirectAttributes) {
        try {
            employeeService.softDeleteEmployee(employeeNumber);
            redirectAttributes.addFlashAttribute("message", "Employee soft-deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while soft-deleting the employee.");
        }
        return "redirect:/employees";
    }
}
