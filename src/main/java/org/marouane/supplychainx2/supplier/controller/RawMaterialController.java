package org.marouane.supplychainx2.supplier.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.RawMaterialDTO;
import org.marouane.supplychainx2.supplier.DTO.response.rawMaterial.RawMaterialDTOResponse;
import org.marouane.supplychainx2.supplier.service.IRawMaterialService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/raw-material")
public class RawMaterialController {
    private final IRawMaterialService rawMaterialService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody RawMaterialDTO rawMaterialDTO, BindingResult result){
        return ResponseEntity.ok(rawMaterialService.create(rawMaterialDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(rawMaterialService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RawMaterialDTOResponse>> getAll(){
        return ResponseEntity.ok(rawMaterialService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody  RawMaterialDTO rawMaterialDTO, BindingResult result ){

        return ResponseEntity.ok(rawMaterialService.update(rawMaterialDTO , id));
    }

    @GetMapping("/filter/stock/less/{stock}")
    public ResponseEntity<List<RawMaterialDTOResponse>> filterByStockLessThenOrEqual(@PathVariable("stock") Integer stock){
        List<RawMaterialDTOResponse> rawMaterialDTOResponses = rawMaterialService.getByLessThenOrEqualStock(stock);
        return ResponseEntity.ok(rawMaterialDTOResponses);
    }

    @GetMapping("/filter/stock/greater/{stock}")
    public ResponseEntity<List<RawMaterialDTOResponse>> filterByStockGreaterThenOrEqual(@PathVariable("stock") Integer stock){
        List<RawMaterialDTOResponse> rawMaterialDTOResponses = rawMaterialService.getByGreaterThenOrEqualStock(stock);
        return ResponseEntity.ok(rawMaterialDTOResponses);
    }
}
