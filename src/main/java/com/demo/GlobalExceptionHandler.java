package com.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.exception.ErrorResponse;
import com.demo.exception.NoSuchFrieneExistException;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoSuchFrieneExistException.class)
	protected ResponseEntity<?> handleNoSuchFrieneExistException(NoSuchFrieneExistException ex, HttpServletRequest request){ 
		
		  ErrorResponse errorResponse = new ErrorResponse();
		  
		  errorResponse.setErrorMassage(ex.getMessage());
		  errorResponse.setRequestUri(request.getServletPath());
		  errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		  errorResponse.setTimeStamp(new Date());
		 
		return ResponseEntity.ok(errorResponse);
	}
}
