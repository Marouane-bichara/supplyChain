package org.marouane.supplychainx2.Production.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.Production.DTO.BillOfMaterialDTO;
import org.marouane.supplychainx2.Production.DTO.response.billOfMaterial.BillOfMaterialDTOResponse;
import org.marouane.supplychainx2.Production.entity.BillOfMaterial;

@Mapper(componentModel = "spring", uses = IProductMapper.class)
public interface IBillOfMaterialMapper {
    BillOfMaterialDTO toDto(BillOfMaterial billOfMaterial);

    BillOfMaterial toEntity(BillOfMaterialDTO billOfMaterialDTO);

    BillOfMaterialDTOResponse toResponseDto(BillOfMaterial billOfMaterial);
}
