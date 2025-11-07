package org.marouane.supplychainx2.supplier.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.supplier.DTO.SupplierDTO;
import org.marouane.supplychainx2.supplier.DTO.response.rawMaterial.SupplierDTOResponseWithoutList;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.SupplierDTOResponse;
import org.marouane.supplychainx2.supplier.entity.Supplier;

@Mapper(componentModel = "spring")
public interface ISupplierMapper {
    SupplierDTO toDTO(Supplier supplier);
    Supplier toEntity(SupplierDTO supplierDTO);
    SupplierDTOResponse toResponseDTO(Supplier supplier);
    SupplierDTOResponseWithoutList toResponseDTOWithoutList(Supplier supplier);
}
