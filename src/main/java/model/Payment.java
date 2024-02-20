package model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    private Customer customerNumber;

    @Id
    @Column(name = "checkNumber", length = 50)
    private String checkNumber;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "amount", precision = 10, scale = 2)
    private Double amount;
}
