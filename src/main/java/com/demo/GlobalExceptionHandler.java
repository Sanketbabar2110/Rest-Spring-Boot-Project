package com.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.exception.ErrorResponse;
import com.demo.exception.NoSuchFrieneExistException;

@ControllerAdvice
public class GlobalExceptionHandler  {

	@ResponseBody
	@ExceptionHandler(NoSuchFrieneExistException.class)
	protected ErrorResponse handleNoSuchFrieneExistException(Exception ex, HttpServletRequest request){

		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setErrorMassage(ex.getMessage());
		errorResponse.setRequestUri(request.getServletPath());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(new Date());
		
		return errorResponse;
	}
}
