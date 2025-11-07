package org.marouane.supplychainx2.Production.repository;

import org.marouane.supplychainx2.Production.entity.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {
}
