package org.marouane.supplychainx2.supplier.repository;

import org.marouane.supplychainx2.supplier.entity.RawMaterialSupplyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRawMaterialSupplyOrderRepository extends JpaRepository<RawMaterialSupplyOrder, Long> {
}
