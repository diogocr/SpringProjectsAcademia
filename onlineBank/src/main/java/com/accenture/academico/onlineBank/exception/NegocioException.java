package com.accenture.academico.onlineBank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class NegocioException extends RuntimeException{
	
	@ExceptionHandler(RegraNegocioException.class)
	public ResponseStatusException negocio(RegraNegocioException e) {
		return new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
	}
	
}
