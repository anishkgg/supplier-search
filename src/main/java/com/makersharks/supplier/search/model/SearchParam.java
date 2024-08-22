package com.makersharks.supplier.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchParam {

	@Nonnull
	@JsonProperty("location")
	private String location;

	@Nonnull
	@JsonProperty("nature_of_business")
	private String businessNature;

	@Nonnull
	@JsonProperty("manufacturing_process")
	private String manufacturingProcess;
}