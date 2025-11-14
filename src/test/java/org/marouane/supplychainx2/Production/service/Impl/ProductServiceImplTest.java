package org.marouane.supplychainx2.Production.service.Impl;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marouane.supplychainx2.Production.DTO.ProductDTO;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;
import org.marouane.supplychainx2.Production.entity.Product;
import org.marouane.supplychainx2.Production.mapper.IProductMapper;
import org.marouane.supplychainx2.Production.repository.IProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void createProduct() {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Laptop");
        productDTO.setStock(10);
        productDTO.setCost(1200.0);
        productDTO.setProductionTime(5);

        Product productEntity = new Product();
        productEntity.setName("Laptop");
        productEntity.setStock(10);
        productEntity.setCost(1200.0);
        productEntity.setProductionTime(5);

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setName("Laptop");
        savedProduct.setStock(10);
        savedProduct.setCost(1200.0);
        savedProduct.setProductionTime(5);

        ProductDTOResponse response = new ProductDTOResponse(
                1L,
                "Laptop",
                5,
                1200.0,
                10
        );

        when(productMapper.toEntity(productDTO)).thenReturn(productEntity);
        when(productRepository.save(productEntity)).thenReturn(savedProduct);
        when(productMapper.toResponseDto(savedProduct)).thenReturn(response);

        ProductDTOResponse result = productService.createProduct(productDTO);

        assertNotNull(result);
        assertEquals(1L, result.getIdProduct());
        assertEquals("Laptop", result.getName());
        assertEquals(5, result.getProductionTime());
        assertEquals(1200.0, result.getCost());
        assertEquals(10, result.getStock());

        verify(productMapper, times(1)).toEntity(productDTO);
        verify(productRepository, times(1)).save(productEntity);
        verify(productMapper, times(1)).toResponseDto(savedProduct);
    }

    @Test
    void updateProduct() {

        Long productId = 1L;

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Laptop Pro");
        productDTO.setStock(15);
        productDTO.setCost(1500.0);
        productDTO.setProductionTime(6);

        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setName("Laptop");
        existingProduct.setStock(10);
        existingProduct.setCost(1200.0);
        existingProduct.setProductionTime(5);

        Product updatedProduct = new Product();
        updatedProduct.setId(productId);
        updatedProduct.setName("Laptop Pro");
        updatedProduct.setStock(15);
        updatedProduct.setCost(1500.0);
        updatedProduct.setProductionTime(6);

        ProductDTOResponse response = new ProductDTOResponse(
                productId,
                "Laptop Pro",
                6,
                1500.0,
                15
        );

        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);
        when(productMapper.toResponseDto(updatedProduct)).thenReturn(response);

        ProductDTOResponse result = productService.updateProduct(productId, productDTO);

        assertNotNull(result);
        assertEquals(productId, result.getIdProduct());
        assertEquals("Laptop Pro", result.getName());
        assertEquals(6, result.getProductionTime());
        assertEquals(1500.0, result.getCost());
        assertEquals(15, result.getStock());

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).save(existingProduct);
        verify(productMapper, times(1)).toResponseDto(updatedProduct);
    }

    @Test
    void deleteProduct() {
        Long productId = 1L;

        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setName("Laptop");
        existingProduct.setStock(10);
        existingProduct.setCost(1200.0);
        existingProduct.setProductionTime(5);

        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(existingProduct));

        productService.deleteProduct(productId);

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).delete(existingProduct);

    }

    @Test
    void getProductById() {

        Long productId = 1L;

        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setName("Laptop");
        existingProduct.setStock(10);
        existingProduct.setCost(1200.0);
        existingProduct.setProductionTime(5);


        ProductDTOResponse response = new ProductDTOResponse(
                productId,
                "Laptop",
                5,
                1200.0,
                10
        );

        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(existingProduct));
        when(productMapper.toResponseDto(existingProduct)).thenReturn(response);

        ProductDTOResponse result = productService.getProductById(productId);

        assertNotNull(result);
        assertEquals(productId, result.getIdProduct());
        assertEquals("Laptop", result.getName());
        assertEquals(5, result.getProductionTime());
        assertEquals(1200.0, result.getCost());
        assertEquals(10, result.getStock());


        verify(productRepository, times(1)).findById(productId);
        verify(productMapper, times(1)).toResponseDto(existingProduct);
    }

    @Test
    void getAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Laptop");
        product1.setStock(10);
        product1.setCost(1200.0);
        product1.setProductionTime(5);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Mouse");
        product2.setStock(50);
        product2.setCost(25.0);
        product2.setProductionTime(1);

        List<Product> productList = List.of(product1, product2);


        ProductDTOResponse response1 = new ProductDTOResponse(1L, "Laptop", 5, 1200.0, 10);
        ProductDTOResponse response2 = new ProductDTOResponse(2L, "Mouse", 1, 25.0, 50);
        List<ProductDTOResponse> expectedResponses = List.of(response1, response2);


        when(productRepository.findAll()).thenReturn(productList);
        when(productMapper.toResponseDto(product1)).thenReturn(response1);
        when(productMapper.toResponseDto(product2)).thenReturn(response2);


        List<ProductDTOResponse> result = productService.getAllProducts();


        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Laptop", result.get(0).getName());
        assertEquals("Mouse", result.get(1).getName());


        verify(productRepository, times(1)).findAll();
        verify(productMapper, times(1)).toResponseDto(product1);
        verify(productMapper, times(1)).toResponseDto(product2);
    }

    @Test
    void getProductsByStockLessThan() {
        int threshold = 20;


        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Laptop");
        product1.setStock(10);
        product1.setCost(1200.0);
        product1.setProductionTime(5);


        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Keyboard");
        product2.setStock(15);
        product2.setCost(50.0);
        product2.setProductionTime(1);


        List<Product> filteredProducts = List.of(product1, product2);


        ProductDTOResponse response1 = new ProductDTOResponse(1L, "Laptop", 5, 1200.0, 10);
        ProductDTOResponse response2 = new ProductDTOResponse(2L, "Keyboard", 1, 50.0, 15);
        List<ProductDTOResponse> expectedResponses = List.of(response1, response2);


        when(productRepository.findByStockLessThan(threshold)).thenReturn(filteredProducts);
        when(productMapper.toResponseDto(product1)).thenReturn(response1);
        when(productMapper.toResponseDto(product2)).thenReturn(response2);


        List<ProductDTOResponse> result = productService.getProductsByStockLessThan(threshold);


        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Laptop", result.get(0).getName());
        assertEquals("Keyboard", result.get(1).getName());


        verify(productRepository, times(1)).findByStockLessThan(threshold);
        verify(productMapper, times(1)).toResponseDto(product1);
        verify(productMapper, times(1)).toResponseDto(product2);
    }
}