package io.eliseoorellana.classicmodels.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.eliseoorellana.classicmodels.model.Employee;
import io.eliseoorellana.classicmodels.service.EmployeeService;

@RestController
public class SalesManagerRestController {

    private final EmployeeService employeeService;

    // Constructor con inyección de dependencias
    public SalesManagerRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // @Autowired private EmployeeService employeeService;

    @GetMapping("/api/salesManager")
    
    // para testear ruta: http://localhost:8080/api/salesManager?officeCode=USA&salesManagerId=1143
    
    public ResponseEntity<List<Employee>> getSalesManagerRest(
            @RequestParam(required = false) String officeCode,
            @RequestParam(required = false) Integer salesManagerId) {
        List<Employee> salesManager;
        if (officeCode != null && salesManagerId != null) {
            // Obtener representantes de venta para la oficina y el sales manager
            // especificados
            salesManager = employeeService.listaVendedor(salesManagerId, officeCode);
            return ResponseEntity.ok().body(salesManager);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
