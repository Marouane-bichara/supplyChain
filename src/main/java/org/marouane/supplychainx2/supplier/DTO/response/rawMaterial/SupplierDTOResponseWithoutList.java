package org.marouane.supplychainx2.supplier.DTO.response.rawMaterial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTOResponseWithoutList {
    private String firstName;

    private String lastName;

    private String contact;

    private Double rating;

    private Integer leadTime;
}
