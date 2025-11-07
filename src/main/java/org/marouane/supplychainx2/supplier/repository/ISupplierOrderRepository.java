package org.marouane.supplychainx2.supplier.repository;

import org.marouane.supplychainx2.supplier.entity.SupplyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierOrderRepository extends JpaRepository<SupplyOrder, Long> {
}
