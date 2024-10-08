package com.makersharks.supplier.search.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.makersharks.supplier.search.model.SupplierSearchResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
		SupplierSearchResponse response = new SupplierSearchResponse();
		response.setError(errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
