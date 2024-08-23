package com.makersharks.supplier.search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class SupplierSearchResponse {

	private boolean success;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPages;
	private List<SupplierDTO> suppliers;
	private String error;
}
