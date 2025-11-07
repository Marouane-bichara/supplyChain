package org.marouane.supplychainx2.Production.controller;


import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.BillOfMaterialDTO;
import org.marouane.supplychainx2.Production.service.IBillOfMaterialService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/api/Bill-Off-Material")
public class BillOfMaterialController {

    private final IBillOfMaterialService billOfMaterialService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody BillOfMaterialDTO billOfMaterialDTO)
    {
        return ResponseEntity.ok(billOfMaterialService.createBillOfMaterial(billOfMaterialDTO));
    }
}
