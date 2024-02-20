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
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "productCode", length = 15)
    private String productCode;

    @Column(name = "productName", length = 70)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine")
    private ProductLine productLine;

    @Column(name = "productScale", length = 10)
    private String productScale;

    @Column(name = "productVendor", length = 50)
    private String productVendor;

    @Column(name = "productDescription", length = 2000)
    private String productDescription;

    @Column(name = "quantityInStock")
    private int quantityInStock;

    @Column(name = "buyPrice", precision = 10, scale = 2)
    private double buyPrice;

    @Column(name = "MSRP", precision = 10, scale = 2)
    private double msrp;

}
