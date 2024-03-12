package io.eliseoorellana.classicmodels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import io.eliseoorellana.classicmodels.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDeletedFalse();

    // Método para obtener una lista de empleados basada en un gerente de ventas y
    // un país de oficina
    // Aquí agregamos el método para la consulta compuesta
    @Query("SELECT e FROM Employee e INNER JOIN e.office o WHERE e.reportsTo = :idSM AND o.country = :offCountry")
    List<Employee> listaVendedor(Integer idSM, String offCountry);

    @Query("SELECT CONCAT(eSup.firstName, ' ', eSup.lastName) " +
            "FROM Employee eSup " +
            "WHERE eSup.employeeNumber = :idSM")
    String findSupervisorNameById(Integer idSM);

    @Query("SELECT DISTINCT e.jobTitle FROM Employee e")
    List<String> findDistinctJobTitles();

    List<Employee> findByReportsTo(int id);

}
