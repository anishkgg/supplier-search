package com.makersharks.supplier.search.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
    private Integer supplierId;

	@Column(name = "company_name")
    private String companyName;

	@Column(name = "website")
    private String website;

	@Column(name = "location")
    private String location;

	@Column(name = "nature_of_business")
    private String businessNature;
    
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SupplierManufacturingProcess> manufacturingProcesses;
}
