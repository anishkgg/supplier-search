package com.makersharks.supplier.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.supplier.search.entity.Supplier;
import com.makersharks.supplier.search.model.SearchParam;
import com.makersharks.supplier.search.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/query")
	public ResponseEntity<List<Supplier>> searchSuppliers(@RequestBody SearchParam searchParam, Pageable pageable) {
		Page<Supplier> suppliers = supplierService.searchSuppliers(searchParam, pageable);
		return ResponseEntity.ok(suppliers.getContent());
	}
}
