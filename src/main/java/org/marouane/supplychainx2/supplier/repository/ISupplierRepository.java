package org.marouane.supplychainx2.supplier.repository;

import org.marouane.supplychainx2.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository  extends JpaRepository<Supplier, Long> {
    Supplier findSupplierByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

}
