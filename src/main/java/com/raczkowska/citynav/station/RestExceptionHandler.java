package com.raczkowska.citynav.station;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({StationNotFoundException.class, BikeNotFoundException.class, PositionNotFoundException.class})
	protected ResponseEntity<Object> handleEntityNotFound(
		Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
