package org.marouane.supplychainx2.Production.repository;

import org.marouane.supplychainx2.Production.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStockLessThan(Integer threshold);
}
