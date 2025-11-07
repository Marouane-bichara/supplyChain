package org.marouane.supplychainx2.supplier.repository;

import org.marouane.supplychainx2.supplier.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRawMaterialRepository extends JpaRepository<RawMaterial, Long> {
    List<RawMaterial> findRawMaterialByStockLessThanEqual(Integer stock);
    List<RawMaterial> findRawMaterialByStockGreaterThanEqual(Integer stock);
}
