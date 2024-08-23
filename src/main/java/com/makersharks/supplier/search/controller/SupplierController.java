package com.makersharks.supplier.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.supplier.search.model.SearchParam;
import com.makersharks.supplier.search.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/query")
	public ResponseEntity<Object> searchSuppliers(@Valid @RequestBody SearchParam searchParam, Pageable pageable) {
		return supplierService.searchSuppliers(searchParam, pageable);
	}
}
