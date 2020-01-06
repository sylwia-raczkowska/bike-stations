package com.raczkowska.citynav.station;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(StationNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(
		EntityNotFoundException ex) {
		return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
	}
}
