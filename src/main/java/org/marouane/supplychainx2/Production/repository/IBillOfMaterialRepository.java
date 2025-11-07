package org.marouane.supplychainx2.Production.repository;

import org.marouane.supplychainx2.Production.entity.BillOfMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillOfMaterialRepository extends JpaRepository<BillOfMaterial, Long> {
}
