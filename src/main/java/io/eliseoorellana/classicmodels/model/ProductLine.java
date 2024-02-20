package io.eliseoorellana.classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine {

    @Id
    @Column(name = "productLine", length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Column(name = "htmlDescription", length = 100)
    private String htmlDescription;

    @Column(name = "image", length = 100)
    private String image;

}
