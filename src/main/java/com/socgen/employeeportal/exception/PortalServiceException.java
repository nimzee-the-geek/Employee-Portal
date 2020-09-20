/**
 * 
 */
package com.socgen.employeeportal.exception;

/**
 * @author Nimesh t
 *
 */
public class PortalServiceException extends RuntimeException{
	
	public PortalServiceException(String message) {
		super(message);
	}
	
	public PortalServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
