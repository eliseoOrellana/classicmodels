package io.eliseoorellana.classicmodels.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.eliseoorellana.classicmodels.Repository.EmployeeRepository;
import io.eliseoorellana.classicmodels.model.Employee;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    // public List<Employee> getAllEmployees() {
    //     return employeeRepository.findAll();
    // }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findByDeletedFalse(); // Obtener empleados no eliminados lógicamente
        } catch (Exception e) {
            // Manejar la excepción adecuadamente (registra el error, notifica al usuario, etc.)
            e.printStackTrace(); // Manejo básico de la excepción imprimiendo la traza en la consola
            return Collections.emptyList(); // Devolver una lista vacía en caso de error
        }
    }

    public Employee getEmployeeById(int id) {
        try {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            return employeeOptional.orElse(null);
        } catch (Exception e) {
            // Manejar la excepción adecuadamente (registra el error, notifica al usuario, etc.)
            e.printStackTrace(); // Manejo básico de la excepción imprimiendo la traza en la consola
            return null; // Devolver null en caso de error
        }
    }

    public void saveOrUpdate(Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            // Manejar la excepción adecuadamente (registra el error, notifica al usuario, etc.)
            e.printStackTrace(); // Manejo básico de la excepción imprimiendo la traza en la consola
        }
    }

    public void delete(int id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            // Manejar la excepción adecuadamente (registra el error, notifica al usuario, etc.)
            e.printStackTrace(); // Manejo básico de la excepción imprimiendo la traza en la consola
        }
    }

    public void softDelete(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setDeleted(true);
            employeeRepository.save(employee);
        }
    }


    // public List<Employee> findEmployeesByOfficeAndJobTitle(Office office, String
    // jobTitle) {
    // return
    // employeeRepository.findByOfficeAndJobTitleOrderByFirstNameAscLastNameAsc(office,
    // jobTitle);
    // }
}