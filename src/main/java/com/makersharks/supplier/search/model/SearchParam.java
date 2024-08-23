package com.makersharks.supplier.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchParam {

	@NotNull(message = "location cannot be null")
	@JsonProperty("location")
	private String location;

	@NotNull(message = "nature of business cannot be null")
	@JsonProperty("nature_of_business")
	private String businessNature;

	@NotNull(message = "manufacturing process cannot be null")
	@JsonProperty("manufacturing_process")
	private String manufacturingProcess;
}