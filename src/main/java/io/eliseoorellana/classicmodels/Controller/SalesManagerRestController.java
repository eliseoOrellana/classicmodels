package io.eliseoorellana.classicmodels.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.eliseoorellana.classicmodels.Service.EmployeeService;
import io.eliseoorellana.classicmodels.model.Employee;



@RestController
public class SalesManagerRestController {

    private final EmployeeService employeeService;

    // Constructor con inyección de dependencias
    public SalesManagerRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/salesManager")
    @CrossOrigin(origins = {"http://localhost:8080"})
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
