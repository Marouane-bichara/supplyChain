package org.marouane.supplychainx2.Production.mapper;

import org.mapstruct.Mapper;
import org.marouane.supplychainx2.Production.DTO.ProductDTO;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;
import org.marouane.supplychainx2.Production.entity.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDTO);

    ProductDTOResponse toResponseDto(Product product);
}
