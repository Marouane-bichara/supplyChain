package org.marouane.supplychainx2.supplier.DTO.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTOResponse {
    private String firstName;
    private String lastName;
    private String contact;
    private Double rating;
    private Integer leadTime;
    private List<RawMaterialDTOResponseWithoutList> rawMaterials;
}
