package io.eliseoorellana.classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "offices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Id
    @Column(name = "officeCode", length = 10)
    private String officeCode;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "addressLine1", length = 50)
    private String addressLine1;

    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "postalCode", length = 15)
    private String postalCode;

    @Column(name = "territory", length = 10)
    private String territory;

    private boolean deleted = Boolean.FALSE; // Campo para el soft delete iniciandolos como false
}
