package br.com.cldelias.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cldelias.services.exceptions.ConversionException;
import br.com.cldelias.services.exceptions.FileIntegrityException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(FileIntegrityException.class)
	public ResponseEntity<StandardError> fileIntegrity(FileIntegrityException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "file integrity", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(ConversionException.class)
	public ResponseEntity<StandardError> conversionFile(ConversionException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "conversion file", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
