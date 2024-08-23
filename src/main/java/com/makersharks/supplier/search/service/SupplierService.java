package com.makersharks.supplier.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.makersharks.supplier.search.entity.Supplier;
import com.makersharks.supplier.search.entity.SupplierManufacturingProcess;
import com.makersharks.supplier.search.model.SearchParam;
import com.makersharks.supplier.search.model.SupplierDTO;
import com.makersharks.supplier.search.model.SupplierSearchResponse;
import com.makersharks.supplier.search.repository.SupplierRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public ResponseEntity<Object> searchSuppliers(SearchParam searchParam, Pageable pageable) {
		SupplierSearchResponse response = new SupplierSearchResponse();
		try {
			Page<Supplier> supplierPageResult = supplierRepository.findSuppliersBy(searchParam.getLocation(),
					searchParam.getBusinessNature(), searchParam.getManufacturingProcess(), pageable);
			// null check
			if (supplierPageResult == null) {
				throw new Exception("resultset is null");
			}
			
			response.setPageIndex(supplierPageResult.getNumber());
			response.setPageSize(supplierPageResult.getSize());
			response.setTotalPages(supplierPageResult.getTotalPages());

			List<SupplierDTO> supplierList = new ArrayList<>();
			for (Supplier supplier : supplierPageResult.getContent()) {
				SupplierDTO supplierDto = new SupplierDTO();
				supplierDto.setSupplierId(supplier.getSupplierId());
				supplierDto.setCompanyName(supplier.getCompanyName());
				supplierDto.setLocation(supplier.getLocation());
				supplierDto.setWebsite(supplier.getWebsite());
				supplierDto.setBusinessNature(supplier.getBusinessNature());

				List<String> processNames = new ArrayList<>();
				List<SupplierManufacturingProcess> manufacturingProcesses = supplier.getManufacturingProcesses();
				for (SupplierManufacturingProcess process : manufacturingProcesses) {
					processNames.add(process.getProcessName());
				}

				supplierDto.setManufacturingProcesses(processNames);
				supplierList.add(supplierDto);
			}

			response.setSuccess(true);
			response.setSuppliers(supplierList);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Exception occurred in getting supplier list, error: ", e);
			response.setError(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
