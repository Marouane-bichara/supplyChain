package org.marouane.supplychainx2.Production.service.Impl;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.ProductDTO;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;
import org.marouane.supplychainx2.Production.entity.Product;
import org.marouane.supplychainx2.Production.mapper.IProductMapper;
import org.marouane.supplychainx2.Production.repository.IProductRepository;
import org.marouane.supplychainx2.Production.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;


    @Override
    public ProductDTOResponse createProduct(ProductDTO productDTO)
    {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDto(savedProduct);

    }


    @Override
    public ProductDTOResponse updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setProductionTime(productDTO.getProductionTime());
        existingProduct.setCost(productDTO.getCost());
        existingProduct.setStock(productDTO.getStock());

        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.toResponseDto(updatedProduct);
    }


    @Override
    public void deleteProduct(Long id){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        productRepository.delete(existingProduct);
    }


    @Override
    public ProductDTOResponse getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        return productMapper.toResponseDto(product);
    }


    @Override
    public List<ProductDTOResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toResponseDto)
                .toList();
    }


    @Override
    public List<ProductDTOResponse> getProductsByStockLessThan(Integer threshold) {
        List<Product> products = productRepository.findByStockLessThan(threshold);
        return products.stream()
                .map(productMapper::toResponseDto)
                .toList();
    }



}
