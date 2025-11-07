package org.marouane.supplychainx2.supplier.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.supplier.entity.enume.SupplyOrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplyorders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private SupplyOrderStatus status;

    @OneToMany(mappedBy = "supplyOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RawMaterialSupplyOrder> rawMaterialSupplyOrders = new ArrayList<>();


    public void addRawMaterialSupplyOrder(RawMaterialSupplyOrder item) {
        this.rawMaterialSupplyOrders.add(item);
        item.setSupplyOrder(this);
    }
}
