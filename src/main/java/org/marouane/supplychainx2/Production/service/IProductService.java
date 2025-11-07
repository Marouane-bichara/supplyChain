package org.marouane.supplychainx2.Production.service;

import org.marouane.supplychainx2.Production.DTO.ProductDTO;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;

import java.util.List;

public interface IProductService {

    ProductDTOResponse createProduct(ProductDTO productDTO);

    ProductDTOResponse updateProduct(Long id, ProductDTO productDTO);
//
    void deleteProduct(Long id);
//
    ProductDTOResponse getProductById(Long id);
//
    List<ProductDTOResponse> getAllProducts();
//
    List<ProductDTOResponse> getProductsByStockLessThan(Integer threshold);

}
