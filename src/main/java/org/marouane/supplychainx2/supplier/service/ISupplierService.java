package org.marouane.supplychainx2.supplier.service;

import org.marouane.supplychainx2.supplier.DTO.SupplierDTO;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.SupplierDTOResponse;
import org.marouane.supplychainx2.supplier.entity.Supplier;

import java.util.List;

public interface ISupplierService {
    Supplier createSupplier(SupplierDTO supplier);
    SupplierDTOResponse getSupplierById(Long id);
    SupplierDTO updateSupplier(SupplierDTO supplier, Long id);
    SupplierDTOResponse searchSupplierByFirstNameAndLastName(String firstName, String lastName);
    List<SupplierDTOResponse> getAllSuplliers();
}
