package com.imaginnoavte.employeeService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.imaginnoavte.employeeService.response.ExpResponse;

import jakarta.servlet.http.HttpServletRequest;

public class customException extends RuntimeException{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExpResponse handleException(final Exception exception, final HttpServletRequest request) {
		exception.printStackTrace();
		ExpResponse error = new ExpResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}
}
