package io.eliseoorellana.classicmodels.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customerNumber")
    private Long customerNumber;

    @Column(name = "customerName", length = 50)
    private String customerName;

    @Column(name = "contactLastName", length = 50)
    private String contactLastName;

    @Column(name = "contactFirstName", length = 50)
    private String contactFirstName;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "addressLine1", length = 50)
    private String addressLine1;

    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "postalCode", length = 15)
    private String postalCode;

    @Column(name = "country", length = 50)
    private String country;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    private Employee salesRepEmployeeNumber;

    @Column(name = "creditLimit", precision = 10, scale = 2)
    private Double creditLimit;

    @OneToMany(mappedBy = "customerNumber")
    private List<Order> orders;

    @OneToMany(mappedBy = "customerNumber")
    private List<Payment> payments;

}
