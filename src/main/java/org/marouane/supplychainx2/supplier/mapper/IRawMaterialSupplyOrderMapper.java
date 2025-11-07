package org.marouane.supplychainx2.supplier.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder.RawMaterialSupplyOrderDTOResponse;
import org.marouane.supplychainx2.supplier.entity.RawMaterialSupplyOrder;

@Mapper(componentModel = "spring", uses = IRawMaterialMapper.class)
public interface IRawMaterialSupplyOrderMapper {
    RawMaterialSupplyOrderDTOResponse toDtoResponse(RawMaterialSupplyOrder rawMaterialSupplyOrder);
}
