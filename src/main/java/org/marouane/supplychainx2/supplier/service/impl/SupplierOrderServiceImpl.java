package org.marouane.supplychainx2.supplier.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.SupplyOrderDTO;
import org.marouane.supplychainx2.supplier.DTO.response.SupplierOrder.SupplierOrderDTOResponse;
import org.marouane.supplychainx2.supplier.entity.RawMaterial;
import org.marouane.supplychainx2.supplier.entity.RawMaterialSupplyOrder;
import org.marouane.supplychainx2.supplier.entity.Supplier;
import org.marouane.supplychainx2.supplier.entity.SupplyOrder;
import org.marouane.supplychainx2.supplier.entity.enume.SupplyOrderStatus;
import org.marouane.supplychainx2.supplier.mapper.ISupplyOrderMapper;
import org.marouane.supplychainx2.supplier.repository.IRawMaterialRepository;
import org.marouane.supplychainx2.supplier.repository.ISupplierOrderRepository;
import org.marouane.supplychainx2.supplier.repository.ISupplierRepository;
import org.marouane.supplychainx2.supplier.service.ISupplierOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class SupplierOrderServiceImpl implements ISupplierOrderService {
    private final ISupplierOrderRepository supplierOrderRepository;
    private final ISupplyOrderMapper supplyOrderMapper;
    private final ISupplierRepository supplierRepository;
    private final IRawMaterialRepository rawMaterialRepository;

    @Override
    public  List<SupplierOrderDTOResponse> getAllSuplliersOrders(){

    List<SupplyOrder> supplyOrders = supplierOrderRepository.findAll();

    List<SupplierOrderDTOResponse> supplierOrderDTOResponses = supplyOrders.stream().map(supplyOrderMapper::toResponse).toList();

    return  supplierOrderDTOResponses;
    }


    @Override
    public SupplierOrderDTOResponse getSupplierOrderById(Long id){
        SupplyOrder supplyOrder = supplierOrderRepository.findById(id).orElseThrow(()-> new RuntimeException("it is not found"));
        SupplierOrderDTOResponse supplierOrderDTOResponse = supplyOrderMapper.toResponse(supplyOrder);
        return  supplierOrderDTOResponse;
    }


    @Override
    @Transactional
    public SupplierOrderDTOResponse createSupplierOrder(SupplyOrderDTO dto) {

        Supplier supplier = supplierRepository.findById(dto.supplierId())
                .orElseThrow(() -> new RuntimeException("Supplier ID not found: " + dto.supplierId()));

        SupplyOrder supplyOrder = new SupplyOrder();
        supplyOrder.setSupplier(supplier);
        supplyOrder.setOrderDate(dto.orderDate());
        supplyOrder.setStatus(SupplyOrderStatus.EN_ATTENTE);

        for (Map.Entry<Long, Integer> entry : dto.items().entrySet()) {
            Long materialId = entry.getKey();
            Integer quantity = entry.getValue();
            RawMaterial material = rawMaterialRepository.findById(materialId)
                    .orElseThrow(() -> new RuntimeException("Raw Material ID not found: " + materialId));
            RawMaterialSupplyOrder lineItem = new RawMaterialSupplyOrder();
            lineItem.setRawMaterial(material);
            lineItem.setQuantity(quantity);
            supplyOrder.addRawMaterialSupplyOrder(lineItem);
        }

        SupplyOrder savedOrder = supplierOrderRepository.save(supplyOrder);

        return supplyOrderMapper.toResponse(savedOrder);
    }


    @Override
    @Transactional
    public SupplierOrderDTOResponse updateSupplierOrder(SupplyOrderDTO supplyOrderDTO, Long id) {
        SupplyOrder supplyOrder = supplierOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("supplier id not found: " + id));
        Supplier supplier = supplierRepository.findById(supplyOrderDTO.supplierId()).orElseThrow(()-> new RuntimeException("the supplier id not found: " + id));
        if (supplyOrder.getStatus().equals(SupplyOrderStatus.RECUE)){
            throw new RuntimeException("you can't update this order because it's already delivered");
        }
        supplyOrder.setSupplier(supplier);
        supplyOrder.setOrderDate(supplyOrderDTO.orderDate());
        supplyOrder.getRawMaterialSupplyOrders().clear();
        for (Map.Entry<Long, Integer> entry : supplyOrderDTO.items().entrySet()) {
            Long materialId = entry.getKey();
            Integer quantity = entry.getValue();
            RawMaterial material = rawMaterialRepository.findById(materialId)
                    .orElseThrow(() -> new RuntimeException("Raw Material ID not found: " + materialId));
            RawMaterialSupplyOrder lineItem = new RawMaterialSupplyOrder();
            lineItem.setRawMaterial(material);
            lineItem.setQuantity(quantity);
            supplyOrder.addRawMaterialSupplyOrder(lineItem);
        }
        SupplyOrder savedOrder = supplierOrderRepository.save(supplyOrder);

        return supplyOrderMapper.toResponse(savedOrder);

    }

}
