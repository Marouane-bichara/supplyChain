package org.marouane.supplychainx2.Production.service.Impl;


import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.Production.DTO.ProductionOrderDTO;
import org.marouane.supplychainx2.Production.DTO.response.productionOrder.ProductionOrderDTOResponse;
import org.marouane.supplychainx2.Production.entity.Product;
import org.marouane.supplychainx2.Production.entity.ProductionOrder;
import org.marouane.supplychainx2.Production.mapper.IProductionOrderMapper;
import org.marouane.supplychainx2.Production.repository.IProductRepository;
import org.marouane.supplychainx2.Production.repository.IProductionOrderRepository;
import org.marouane.supplychainx2.Production.service.IProductionOrderService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductionOrderServiceImpl implements IProductionOrderService {

    private final IProductionOrderRepository productionOrderRepository;
    private final IProductRepository productRepository;
    private final IProductionOrderMapper productionOrderMapper;

    @Override
    public ProductionOrderDTOResponse createProductionOrder(ProductionOrderDTO productionOrderDTO)
    {
        Product product = productRepository.findById(productionOrderDTO.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductionOrder productionOrder = productionOrderMapper.toEntity(productionOrderDTO);
        productionOrder.setProduct(product);

        ProductionOrder savedOrder = productionOrderRepository.save(productionOrder);
        return productionOrderMapper.toResponseDto(savedOrder);

    }

}
