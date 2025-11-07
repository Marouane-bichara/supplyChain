package org.marouane.supplychainx2.Customer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.Customer.entity.enume.DeliveryStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliverys")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDelivery;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private String vehicle;

    @Column
    private String driver;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column
    private LocalDate deliveryDate;

    @Column
    private Double cost;
}
