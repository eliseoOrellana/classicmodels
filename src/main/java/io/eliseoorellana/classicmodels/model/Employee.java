package io.eliseoorellana.classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employeeNumber")
    private int employeeNumber;
    
    @Column(name = "lastName", length = 50)
    private String lastName;
    
    @Column(name = "firstName", length = 50)
    private String firstName;
    
    @Column(name = "extension", length = 10)
    private String extension;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
    private Office office;
    
    
    @Column(name = "reportsTo", length = 10)
    private int reportsTo;
    
    @Column(name = "jobTitle", length = 50)
    private String jobTitle;
}
