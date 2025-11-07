package org.marouane.supplychainx2.Production.DTO.response.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {

    private Long idProduct;
    private String name;
    private Integer productionTime;
    private Double cost;
    private Integer stock;
}
