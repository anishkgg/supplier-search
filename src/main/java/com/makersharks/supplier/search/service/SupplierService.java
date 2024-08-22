package com.makersharks.supplier.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.makersharks.supplier.search.entity.Supplier;
import com.makersharks.supplier.search.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public Page<Supplier> searchSuppliers(String location, String businessNature, String manufacturingProcess,
			Pageable pageable) {
		return supplierRepository.findSuppliersBy(location, businessNature, manufacturingProcess, pageable);
	}
}
