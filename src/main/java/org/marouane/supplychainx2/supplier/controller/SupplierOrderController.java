package org.marouane.supplychainx2.supplier.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.SupplyOrderDTO;
import org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder.SupplierOrderDTOResponse;
import org.marouane.supplychainx2.supplier.service.ISupplierOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/supplier-order")
public class SupplierOrderController {

    private final ISupplierOrderService supplierOrderService;


    @PostMapping("/create")
    public ResponseEntity<?> createSupplierOrder(@Valid @RequestBody SupplyOrderDTO supplyOrderDTO, BindingResult result){

        return ResponseEntity.ok(supplierOrderService.createSupplierOrder(supplyOrderDTO));
    }

    @GetMapping
    public ResponseEntity<List<SupplierOrderDTOResponse>> getAllSupplierOrders(){
        return ResponseEntity.ok(supplierOrderService.getAllSuplliersOrders());
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<?> getSupplierOrderById(@PathVariable("id") Long id){
        return ResponseEntity.ok(supplierOrderService.getSupplierOrderById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSupplierOrder(@Valid @PathVariable("id") Long id, @RequestBody SupplyOrderDTO supplyOrderDTO, BindingResult result){
        SupplierOrderDTOResponse supplyOrder = supplierOrderService.updateSupplierOrder(supplyOrderDTO, id);
        return ResponseEntity.ok(supplyOrder);
    }



}
