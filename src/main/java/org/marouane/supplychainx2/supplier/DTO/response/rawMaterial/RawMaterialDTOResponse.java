package org.marouane.supplychainx2.supplier.DTO.response.rawMaterial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialDTOResponse {

    private String name;
    private String unit;
    private Integer stock;
    private Integer stockMin;
    private List<SupplierDTOResponseWithoutList> suppliers;
}
