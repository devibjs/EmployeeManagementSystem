/**
 * 
 */
package com.aztra.springboot.exception;

/**
 * @author 38609
 *
 */
public class EmployeeNotFoundException extends Exception {

	private String errors;

	/**
	 * 
	 */
	public EmployeeNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return
	 */
	public String getErrors() {
		return this.errors;
	}

}
