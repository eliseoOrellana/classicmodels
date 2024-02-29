package io.eliseoorellana.classicmodels.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.eliseoorellana.classicmodels.Service.EmployeeService;
import io.eliseoorellana.classicmodels.Service.OfficeService;
import io.eliseoorellana.classicmodels.model.Employee;
import io.eliseoorellana.classicmodels.model.Office;


@Controller
@RequestMapping("/sales-manager")
public class SalesManagerController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        // Obtener todos los empleados y oficinas para cargar los selectores
        List<Employee> allEmployees = employeeService.getAllEmployees();
        List<String> allOffices = officeService.findDistinctCountries();

        // Agregar los empleados y oficinas al modelo
        model.addAttribute("allEmployees", allEmployees);
        model.addAttribute("allOffices", allOffices);

        // Crear objetos vacíos para el formulario de búsqueda
        model.addAttribute("employee", new Employee());
        model.addAttribute("office", new Office());

        return "sales-manager";
    }
    

    @PostMapping("/search")
    public String searchEmployees(@ModelAttribute("employee") Employee employee,
    @ModelAttribute("office") Office office,
    Model model) {
        // Realizar la búsqueda de empleados utilizando los datos seleccionados
        List<Employee> employees = employeeService.listaVendedor(employee.getEmployeeNumber(), office.getOfficeCode());

        // Obtener todos los empleados y oficinas para cargar los selectores
        List<Employee> allEmployees = employeeService.getAllEmployees();
        List<String> allOffices = officeService.findDistinctCountries();

        // Agregar los empleados, oficinas y resultados de la búsqueda al modelo
        model.addAttribute("allEmployees", allEmployees);
        model.addAttribute("allOffices", allOffices);
        model.addAttribute("employees", employees);
        
        return "sales-manager";
    }

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("offices", officeService.getAllOffices());
       model.addAttribute("employees", employeeService.getAllEmployees());
        return "mainView";
    }
  }
