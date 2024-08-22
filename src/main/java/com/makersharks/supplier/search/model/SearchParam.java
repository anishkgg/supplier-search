package com.makersharks.supplier.search.model;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class SearchParam {

	@Nonnull
	private String location;
	
	@Nonnull
	private String businessNature;
	
	@Nonnull
    private String manufacturingProcess;
}