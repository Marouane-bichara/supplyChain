package org.marouane.supplychainx2.supplier.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.SupplierDTO;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.SupplierDTOResponse;
import org.marouane.supplychainx2.supplier.mapper.ISupplierMapper;
import org.marouane.supplychainx2.supplier.service.ISupplierService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "supplier crud", description = "manage suppliers")
@RequestMapping("/api/supplier")
public class SupplierController {

    private final ISupplierService supplierService;
    private final ISupplierMapper supplierMapper;
    private final RestTemplateBuilder restTemplateBuilder;



    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRE_APPROVISIONNEMENT')")
    public ResponseEntity<?> create(@Valid @RequestBody SupplierDTO supplierDTO, BindingResult result){

        return ResponseEntity.ok(supplierService.createSupplier(supplierDTO));
    }


    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('RESPONSABLE_ACHATS')")

    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        SupplierDTOResponse supplierDTOResponse = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplierDTOResponse);
    }


    @PutMapping("/update/id/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRE_APPROVISIONNEMENT')")
    public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody SupplierDTO supplierDTO, BindingResult result){
        SupplierDTO supplier = supplierService.updateSupplier(supplierDTO, id);
        return  ResponseEntity.ok(supplier);
    }

    @GetMapping("/search/{firstName}/{lastName}")
    public ResponseEntity<?> searchSupplierByName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        SupplierDTOResponse supplier = supplierService.searchSupplierByFirstNameAndLastName(firstName, lastName);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping
    @PreAuthorize("hasRole('SUPERVISEUR_LOGISTIQUE')")
    public ResponseEntity<List<SupplierDTOResponse>> getAll(){
        List<SupplierDTOResponse> suppliers = supplierService.getAllSuplliers();
        return ResponseEntity.ok(suppliers);
    }
}
