package org.marouane.supplychainx2.Production.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.ProductionOrderDTO;
import org.marouane.supplychainx2.Production.DTO.response.productionOrder.ProductionOrderDTOResponse;
import org.marouane.supplychainx2.Production.service.IProductionOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Production-Order")
public class ProductionOrderController {
    private final IProductionOrderService productionOrderService;


    @PostMapping
    @PreAuthorize("hasRole('CHEF_PRODUCTION')")
    public ResponseEntity<ProductionOrderDTOResponse> createProductionOrder(
            @Valid @RequestBody ProductionOrderDTO productionOrderDTO) {
        ProductionOrderDTOResponse response = productionOrderService.createProductionOrder(productionOrderDTO);
        return ResponseEntity.ok(response);
    }
}
