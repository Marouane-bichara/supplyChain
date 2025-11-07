package org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.RawMaterialDTOResponseWithoutList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialSupplyOrderDTOResponse {
    private Long id;
    private  Integer quantity;
    private RawMaterialDTOResponseWithoutList rawMaterial;
}
