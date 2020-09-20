/**
 * 
 */
package com.socgen.employeeportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Nimesh
 * Exception handler class for handling exception
 * Returns appropriate message to the consumer
 */

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {PortalServiceException.class})
	public ResponseEntity<Object> handleApiRequestException(PortalServiceException e){
		
		ErrorMessage message =  new ErrorMessage(e.getMessage(), e);
		
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}


class ErrorMessage {
	
	private final String message;
	private final Throwable throwable;
	
	/**
	 * @param message
	 * @param throwable
	 * @param httpStatus
	 */
	public ErrorMessage(String message, Throwable throwable) {
		this.message = message;
		this.throwable = throwable;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

}

