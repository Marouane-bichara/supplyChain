package org.marouane.supplychainx2.Production.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Production time is required")
    private Integer productionTime;

    @NotNull(message = "Cost is required")
    private Double cost;

    @NotNull(message = "Stock is required")
    private Integer stock;

}
