package org.marouane.supplychainx2.Production.DTO.response.productionOrder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.Production.DTO.response.product.ProductDTOResponse;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrderDTOResponse {
    private Long idOrder;
    private ProductDTOResponse product;
    private Integer quantity;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
