package io.eliseoorellana.classicmodels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.eliseoorellana.classicmodels.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
   
}
