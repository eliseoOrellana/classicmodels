package io.eliseoorellana.classicmodels.Controller;

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
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", new Employee());
        model.addAttribute("offices", officeService.findDistinctCountries());
        model.addAttribute("office", new Office());
        return "sales-manager";
    }
    

    @PostMapping("/search")
    public String searchEmployees(@ModelAttribute("employee") Employee employee,
                                  @ModelAttribute("office") Office office,
                                  Model model) {
        // Realizar la búsqueda de empleados utilizando los datos seleccionados
        List<Employee> employees = employeeService.listaVendedor(employee.getEmployeeNumber(), office.getOfficeCode());

        // Agregar los resultados al modelo
        model.addAttribute("employees", employees);
        model.addAttribute("offices", officeService.getAllOffices()); // Mantener las opciones de oficinas en la vista
        return "sales-manager";
    }


    
  }
