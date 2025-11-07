package org.marouane.supplychainx2.Production.DTO.response.billOfMaterial;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterialDTOResponse {
    private Long idBillOfMaterial;
    private ProductDTOResponse product;
    private Long materialId;
    private Integer quantity;
}
