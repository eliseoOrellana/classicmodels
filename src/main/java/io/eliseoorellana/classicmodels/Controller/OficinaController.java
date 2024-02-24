package io.eliseoorellana.classicmodels.Controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.eliseoorellana.classicmodels.Service.EmployeeService;
import io.eliseoorellana.classicmodels.Service.OfficeService;
import io.eliseoorellana.classicmodels.model.Employee;
import io.eliseoorellana.classicmodels.model.Office;

@Controller
public class OficinaController {

private OfficeService officeService = null;
private final EmployeeService employeeService;

public OficinaController(OfficeService officeService, EmployeeService employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }

    @GetMapping("/listado")
public String mostrarListadoRepresentantesVenta(Model model) {
    List<Office> offices = officeService.getAllOficinasOrderedByCity();
    List<Employee> employees = employeeService.getAllSalesManagersOrderedByName(); // Obtener todos los empleados, incluidos los representantes de venta
    model.addAttribute("oficinas", offices);
    model.addAttribute("empleados", employees); // Cambiar el nombre del atributo a "empleados"
    return "listado";
}

    
}
