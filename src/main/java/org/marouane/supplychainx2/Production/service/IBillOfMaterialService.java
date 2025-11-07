package org.marouane.supplychainx2.Production.service;

import org.marouane.supplychainx2.Production.DTO.BillOfMaterialDTO;
import org.marouane.supplychainx2.Production.DTO.response.billOfMaterial.BillOfMaterialDTOResponse;

import java.util.List;

public interface IBillOfMaterialService {

    BillOfMaterialDTOResponse createBillOfMaterial(BillOfMaterialDTO billOfMaterialDTO);

//    BillOfMaterialDTOResponse updateBillOfMaterial(Long id, BillOfMaterialDTO billOfMaterialDTO);
//
//    void deleteBillOfMaterial(Long id);
//
//    BillOfMaterialDTOResponse getBillOfMaterialById(Long id);
//
//    List<BillOfMaterialDTOResponse> getAllBillOfMaterials();

}
