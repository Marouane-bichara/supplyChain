package org.marouane.supplychainx2.supplier.DTO.response.supplier;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialDTOResponseWithoutList {
    private String name;
    private String unit;
    private Integer stock;
    private Integer stockMin;
}
