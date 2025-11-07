package org.marouane.supplychainx2.supplier.service.impl;

import lombok.AllArgsConstructor;
import org.marouane.supplychainx2.supplier.DTO.SupplierDTO;
import org.marouane.supplychainx2.supplier.DTO.response.supplier.SupplierDTOResponse;
import org.marouane.supplychainx2.supplier.entity.Supplier;
import org.marouane.supplychainx2.supplier.mapper.ISupplierMapper;
import org.marouane.supplychainx2.supplier.repository.ISupplierRepository;
import org.marouane.supplychainx2.supplier.service.ISupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements ISupplierService {
    private final ISupplierRepository supplierRepository;
    private final ISupplierMapper supplierMapper;


    @Override
    public Supplier createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        return supplierRepository.save(supplier);
    }

    @Override
   public SupplierDTOResponse getSupplierById(Long id){
        Supplier supplier = supplierRepository.findById(id).orElseThrow(()-> new RuntimeException("not found" + id));
        SupplierDTOResponse supplierDTO = supplierMapper.toResponseDTO(supplier);
        return supplierDTO;
    }


    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO, Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("raw material id not found: " + id));
        supplier.setFirstName(supplierDTO.getFirstName());
        supplier.setLastName(supplierDTO.getLastName());
        supplier.setContact(supplierDTO.getContact());
        supplier.setLeadTime(supplierDTO.getLeadTime());
        supplier.setRating(supplierDTO.getRating());
        Supplier supplier1 = supplierRepository.save(supplier);
        SupplierDTO supplierDTOResponse = supplierMapper.toDTO(supplier1);
        return supplierDTOResponse;
    }

    @Override
    public SupplierDTOResponse searchSupplierByFirstNameAndLastName(String firstName, String lastName) {
        Supplier supplier = supplierRepository.findSupplierByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
        if (supplier == null) {
            throw new RuntimeException("Supplier with first name '" + firstName + "' and last name '" + lastName + "' not found");
        }
        SupplierDTOResponse supplierDTOResponse = supplierMapper.toResponseDTO(supplier);
        return supplierDTOResponse;
    }

    @Override
    public List<SupplierDTOResponse> getAllSuplliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTOResponse> supplierDTOResponses = suppliers.stream().map(supplierMapper::toResponseDTO).toList();
        return supplierDTOResponses;
    }

}
