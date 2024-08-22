package com.makersharks.supplier.search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SupplierDTO {
	
	@JsonProperty("supplier_id")
	private Integer supplierId;

	@JsonProperty("company_name")
    private String companyName;

	@JsonProperty("website")
    private String website;

	@JsonProperty("location")
    private String location;

	@JsonProperty("nature_of_business")
    private String businessNature;
    
	@JsonProperty("manufacturing_processes")
    private List<String> manufacturingProcesses;

}
