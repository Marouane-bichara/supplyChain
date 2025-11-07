package org.marouane.supplychainx2.supplier.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.supplier.DTO.RawMaterialDTO;
import org.marouane.supplychainx2.supplier.DTO.response.rawMaterial.RawMaterialDTOResponse;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.RawMaterialDTOResponseWithoutList;
import org.marouane.supplychainx2.supplier.entity.RawMaterial;

@Mapper(componentModel = "spring", uses = ISupplierMapper.class)
public interface IRawMaterialMapper {
    RawMaterialDTO toDto(RawMaterial rawMaterial);
    RawMaterial toEntity(RawMaterialDTO rawMaterialDTO);
    RawMaterialDTOResponse toResponseDto(RawMaterial rawMaterial);
    RawMaterialDTOResponseWithoutList toDtoWithoutList(RawMaterial rawMaterial);
}