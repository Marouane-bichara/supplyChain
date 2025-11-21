package org.marouane.supplychainx2.Production.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.ProductDTO;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;
import org.marouane.supplychainx2.Production.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/api/Product")
public class ProductController {

    private final IProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('CHEF_PRODUCTION')")
    public ResponseEntity<ProductDTOResponse> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTOResponse createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }


    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('CHEF_PRODUCTION')")
    public ResponseEntity<ProductDTOResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        ProductDTOResponse updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasRole('CHEF_PRODUCTION')")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }

    @GetMapping("Get-By-Id/{id}")
    @PreAuthorize("hasRole('SUPERVISEUR_PRODUCTION')")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable Long id) {
        ProductDTOResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping
    @PreAuthorize("hasRole('SUPERVISEUR_PRODUCTION')")
    public ResponseEntity<List<ProductDTOResponse>> getAllProducts() {
        List<ProductDTOResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock/{threshold}")
    public ResponseEntity<List<ProductDTOResponse>> getProductsByStockLessThan(@PathVariable Integer threshold) {
        List<ProductDTOResponse> products = productService.getProductsByStockLessThan(threshold);
        return ResponseEntity.ok(products);
    }

}
