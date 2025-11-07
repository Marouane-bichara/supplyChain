package org.marouane.supplychainx2.Production.service;

import org.marouane.supplychainx2.Production.DTO.ProductionOrderDTO;
import org.marouane.supplychainx2.Production.DTO.response.productionOrder.ProductionOrderDTOResponse;

import java.util.List;

public interface IProductionOrderService {

    ProductionOrderDTOResponse createProductionOrder(ProductionOrderDTO productionOrderDTO);

    ProductionOrderDTOResponse updateProductionOrder(Long id, ProductionOrderDTO productionOrderDTO);

    void deleteProductionOrder(Long id);

    ProductionOrderDTOResponse getProductionOrderById(Long id);

    List<ProductionOrderDTOResponse> getAllProductionOrders();

    List<ProductionOrderDTOResponse> getProductionOrdersByStatus(String status);

}
