package org.marouane.supplychainx2.Production.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.Production.DTO.ProductionOrderDTO;
import org.marouane.supplychainx2.Production.DTO.response.productionOrder.ProductionOrderDTOResponse;
import org.marouane.supplychainx2.Production.entity.ProductionOrder;

@Mapper(componentModel = "spring", uses = IProductMapper.class)
public interface IProductionOrderMapper {

    ProductionOrderDTO toDto(ProductionOrder productionOrder);

    ProductionOrder toEntity(ProductionOrderDTO productionOrderDTO);

    ProductionOrderDTOResponse toResponseDto(ProductionOrder productionOrder);
}
