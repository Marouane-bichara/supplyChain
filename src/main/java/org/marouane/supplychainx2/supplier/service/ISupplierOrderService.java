package org.marouane.supplychainx2.supplier.service;

import org.marouane.supplychainx2.supplier.DTO.SupplyOrderDTO;
import org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder.SupplierOrderDTOResponse;

import java.util.List;

public interface ISupplierOrderService {

    List<SupplierOrderDTOResponse> getAllSuplliersOrders();
    SupplierOrderDTOResponse getSupplierOrderById(Long id);
    SupplierOrderDTOResponse createSupplierOrder(SupplyOrderDTO supplyOrderDTO);
    SupplierOrderDTOResponse updateSupplierOrder(SupplyOrderDTO supplyOrderDTO, Long id);
//    ResponseMessage deleteSupplierOrder(Long id);
}
