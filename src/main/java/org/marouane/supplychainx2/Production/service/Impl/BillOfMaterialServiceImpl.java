package org.marouane.supplychainx2.Production.service.Impl;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.BillOfMaterialDTO;
import org.marouane.supplychainx2.Production.DTO.response.billOfMaterial.BillOfMaterialDTOResponse;
import org.marouane.supplychainx2.Production.entity.BillOfMaterial;
import org.marouane.supplychainx2.Production.entity.Product;
import org.marouane.supplychainx2.Production.mapper.IBillOfMaterialMapper;
import org.marouane.supplychainx2.Production.repository.IBillOfMaterialRepository;
import org.marouane.supplychainx2.Production.repository.IProductRepository;
import org.marouane.supplychainx2.Production.service.IBillOfMaterialService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BillOfMaterialServiceImpl implements IBillOfMaterialService {

    private final IProductRepository productRepository;
    private final IBillOfMaterialMapper billOfMaterialMapper;
    private final IBillOfMaterialRepository billOfMaterialRepository;

    public BillOfMaterialDTOResponse createBillOfMaterial(BillOfMaterialDTO billOfMaterialDTO){
        Product product = productRepository.findById(billOfMaterialDTO.getProduct_id()).orElseThrow(()-> new RuntimeException("Product not found"));

        BillOfMaterial billOfMaterial = billOfMaterialMapper.toEntity(billOfMaterialDTO);

        billOfMaterial.setProduct(product);
        BillOfMaterial savedBillOfMaterial = billOfMaterialRepository.save(billOfMaterial);

        return billOfMaterialMapper.toResponseDto(savedBillOfMaterial);

    }


//    public BillOfMaterialDTOResponse updateBillOfMaterial(Long id, BillOfMaterialDTO billOfMaterialDTO){
//
//    }
}
