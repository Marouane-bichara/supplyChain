package org.marouane.supplychainx2.supplier.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.supplier.DTO.SupplierDTO;
import org.marouane.supplychainx2.supplier.DTO.SupplyOrderDTO;
import org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder.SupplierOrderDTOResponse;
import org.marouane.supplychainx2.supplier.entity.Supplier;
import org.marouane.supplychainx2.supplier.entity.SupplyOrder;

@Mapper(componentModel = "spring", uses = { ISupplierMapper.class, IRawMaterialSupplyOrderMapper.class })
public interface ISupplyOrderMapper {

    //    @Mapping(source = "rawMaterialSupplyOrders", target = "items")
    SupplierOrderDTOResponse toResponse(SupplyOrder supplyOrder);
    SupplyOrder toEntity(SupplyOrderDTO supplyOrderDTO);

}
