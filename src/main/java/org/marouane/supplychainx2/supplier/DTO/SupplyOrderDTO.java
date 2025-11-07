package org.marouane.supplychainx2.supplier.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Map;

public record SupplyOrderDTO(

        @NotNull(message = "Supplier ID cannot be null")
        Long supplierId,

        @NotNull(message = "Order date cannot be null")
        LocalDate orderDate,

        @NotEmpty(message = "Order must have at least one item")
        Map<Long, Integer> items
){}
