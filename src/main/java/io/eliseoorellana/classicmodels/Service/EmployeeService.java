package io.eliseoorellana.classicmodels.Service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.eliseoorellana.classicmodels.Repository.EmployeeRepository;
import io.eliseoorellana.classicmodels.model.Employee;

@Service
public class EmployeeService {
    
private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllSalesManagersOrderedByName() {
        return employeeRepository.findAllByJobTitle("Sales Manager", Sort.by(Sort.Direction.ASC, "lastName"));
    }
}
