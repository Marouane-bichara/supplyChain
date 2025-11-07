package org.marouane.supplychainx2.supplier.service.impl;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.RawMaterialDTO;
import org.marouane.supplychainx2.supplier.DTO.response.rawMaterial.RawMaterialDTOResponse;
import org.marouane.supplychainx2.supplier.entity.RawMaterial;
import org.marouane.supplychainx2.supplier.entity.Supplier;
import org.marouane.supplychainx2.supplier.mapper.IRawMaterialMapper;
import org.marouane.supplychainx2.supplier.repository.IRawMaterialRepository;
import org.marouane.supplychainx2.supplier.repository.IRawMaterialSupplyOrderRepository;
import org.marouane.supplychainx2.supplier.repository.ISupplierRepository;
import org.marouane.supplychainx2.supplier.service.IRawMaterialService;
import org.marouane.supplychainx2.supplier.service.ISupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RawMaterialServiceImpl implements IRawMaterialService {
    private final IRawMaterialRepository rawMaterialRepository;
    private final IRawMaterialMapper rawMaterialMapper;
    private final ISupplierRepository supplierRepository;
    private final IRawMaterialSupplyOrderRepository rawMaterialSupplyOrderRepository;


    @Override
    public RawMaterialDTOResponse create(RawMaterialDTO dto){
        RawMaterial rawMaterial = rawMaterialMapper.toEntity(dto);

        if(dto.getSupplierIds() != null && !dto.getSupplierIds().isEmpty())
        {
            List<Supplier> suppliers = supplierRepository.findAllById(dto.getSupplierIds());
            rawMaterial.setSuppliers(suppliers);
            for (Supplier supplier : suppliers)
            {
                supplier.getRawMaterials().add(rawMaterial);
            }
        }

        RawMaterial rawMaterial1 = rawMaterialRepository.save(rawMaterial);
        RawMaterialDTOResponse rawMaterialDTO = rawMaterialMapper.toResponseDto(rawMaterial1);
        return rawMaterialDTO;
    }


    @Override
    public RawMaterialDTOResponse update(RawMaterialDTO dto, Long id) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(id).orElseThrow(() -> new RuntimeException("raw material id not found: " + id));

        rawMaterial.setName(dto.getName());
        rawMaterial.setStock(dto.getStock());
        rawMaterial.setUnit(dto.getUnit());
        rawMaterial.setStockMin(dto.getStockMin());

        if (dto.getSupplierIds() != null) {
            for (Supplier oldSupplier : rawMaterial.getSuppliers()) {
                oldSupplier.getRawMaterials().remove(rawMaterial);
            }
            List<Supplier> newSuppliers = supplierRepository.findAllById(dto.getSupplierIds());
            rawMaterial.setSuppliers(newSuppliers);
            for (Supplier newSupplier : newSuppliers) {
                newSupplier.getRawMaterials().add(rawMaterial);
            }
        }
        RawMaterial rawMaterial1 = rawMaterialRepository.save(rawMaterial);
        RawMaterialDTOResponse rawMaterialDTO = rawMaterialMapper.toResponseDto(rawMaterial1);
        return rawMaterialDTO;
    }

    public RawMaterialDTOResponse getById(Long id) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(id).orElseThrow(()-> new RuntimeException("raw material id not found: " + id));
        RawMaterialDTOResponse rawMaterialDTOResponse = rawMaterialMapper.toResponseDto(rawMaterial);
        return rawMaterialDTOResponse;
    }


    @Override
    public List<RawMaterialDTOResponse> getAll() {
        List<RawMaterial> rawMaterials = rawMaterialRepository.findAll();
        List<RawMaterialDTOResponse> rawMaterialDTOResponses = rawMaterials.stream().map(rawMaterialMapper::toResponseDto).toList();
        return rawMaterialDTOResponses;
    }


    @Override
    public List<RawMaterialDTOResponse> getByLessThenOrEqualStock(Integer stock) {
        List<RawMaterial> rawMaterials = rawMaterialRepository.findRawMaterialByStockLessThanEqual(stock);
        List<RawMaterialDTOResponse> rawMaterialDTOResponses = rawMaterials.stream().map(rawMaterialMapper::toResponseDto).toList();
        return rawMaterialDTOResponses;
    }

    @Override
    public List<RawMaterialDTOResponse> getByGreaterThenOrEqualStock(Integer stock) {
        List<RawMaterial> rawMaterials = rawMaterialRepository.findRawMaterialByStockGreaterThanEqual(stock);
        List<RawMaterialDTOResponse> rawMaterialDTOResponses = rawMaterials.stream().map(rawMaterialMapper::toResponseDto).toList();
        return rawMaterialDTOResponses;
    }

}
