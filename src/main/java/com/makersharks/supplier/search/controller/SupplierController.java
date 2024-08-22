package com.makersharks.supplier.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.supplier.search.entity.Supplier;
import com.makersharks.supplier.search.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping("/query")
	public ResponseEntity<Page<Supplier>> searchSuppliers(String location, String businessNature,
			String manufacturingProcess, Pageable pageable) {

		Page<Supplier> suppliers = supplierService.searchSuppliers(location, businessNature, manufacturingProcess,
				pageable);
		return ResponseEntity.ok(suppliers);
	}
}
