package org.marouane.supplychainx2.Production.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.Production.entity.enume.ProductionOrderStatus;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ProductionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer Quantity;
    @Enumerated(EnumType.STRING)
    private ProductionOrderStatus productionOrderStatus;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private LocalDate startDate;
    private LocalDate endDate;
}
