package org.marouane.supplychainx2.supplier.DTO;

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
public class SupplierDTO {
    @NotBlank(message = "the first name is required")
    private String firstName;

    @NotBlank(message = "the last name is required")
    private String lastName;

    private String contact;

    @NotNull(message = "the rating is required")
    private Double rating;

    @NotNull(message = "the average date is required")
    private Integer leadTime;
}
