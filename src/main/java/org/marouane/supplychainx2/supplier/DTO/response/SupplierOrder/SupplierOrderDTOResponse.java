package org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marouane.supplychainx2.supplier.DTO.response.rawMaterial.SupplierDTOResponseWithoutList;
import org.marouane.supplychainx2.supplier.entity.enume.SupplyOrderStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierOrderDTOResponse {
    private Long idOrder;
    private SupplierDTOResponseWithoutList supplier;
    private LocalDate orderDate;
    private SupplyOrderStatus status;
    private List<RawMaterialSupplyOrderDTOResponse> rawMaterialSupplyOrders;
}
