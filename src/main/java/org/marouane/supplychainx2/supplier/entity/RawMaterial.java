package org.marouane.supplychainx2.supplier.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.Production.entity.BillOfMaterial;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rawMaterials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;

    private String name;
    private Integer stock;
    private Integer stockMin;
    private String unit;

    @ManyToMany(mappedBy = "rawMaterials")
    private List<Supplier> suppliers = new ArrayList<>();

    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private List<RawMaterialSupplyOrder> rawMaterialSupplyOrders;

    @OneToMany(mappedBy = "rawMaterial")
    private List<BillOfMaterial> billOfMaterials;


}
