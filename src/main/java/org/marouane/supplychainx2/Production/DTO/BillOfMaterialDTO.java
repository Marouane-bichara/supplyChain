package org.marouane.supplychainx2.Production.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterialDTO {

    @NotBlank(message = "product is required")
    private Long product_id;

    @NotBlank(message = "Material is required")
    private Long matariel_id;

    @NotBlank(message = "Quantitiy is required")
    private Integer quantity;

}
