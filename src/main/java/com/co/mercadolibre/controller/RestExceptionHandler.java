package com.co.mercadolibre.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.co.mercadolibre.web.exception.MutantForbiddenException;
import com.co.mercadolibre.web.exception.MutantMismatchException;
import com.co.mercadolibre.web.exception.MutantNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	public RestExceptionHandler() {
		super();
	}

	@ExceptionHandler(MutantForbiddenException.class)
	protected ResponseEntity<Object> handleForbidden(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, "DNA is HUMAN", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
	@ExceptionHandler(MutantNotFoundException.class)
	protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, "mutant not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ MutantMismatchException.class, ConstraintViolationException.class,
			DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST,
				request);
	}
}