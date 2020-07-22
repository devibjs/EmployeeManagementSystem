/**
 * 
 */
package com.aztra.springboot.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author 38609
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Default Exception handler
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ErrorDetails err = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),
				ex.getCause().toString());
		return new ResponseEntity<Object>(err, new HttpHeaders(), err.getStatus());
	}

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationWhenSavingOrUpdating(DataIntegrityViolationException ex) {
		ErrorDetails err = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getCause().toString());
		return new ResponseEntity<Object>(err, new HttpHeaders(), err.getStatus());
	}
	
	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EmployeeNotFoundException ex) {
		ErrorDetails err = new ErrorDetails(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex.getErrors());
		return new ResponseEntity<Object>(err, new HttpHeaders(), err.getStatus());
	}
	
	//Inner Class for API Err
		public class ErrorDetails {

			private HttpStatus status;
			private String message;
			private List<String> errors;
			
			public ErrorDetails(HttpStatus status, String message, List<String> errors) {
				super();
				this.status = status;
				this.message = message;
				this.errors = errors;
			}

			public ErrorDetails(HttpStatus status, String message, String error) {
				super();
				this.status = status;
				this.message = message;
				errors = Arrays.asList(error);
			}

			public HttpStatus getStatus() {
				return status;
			}

			public void setStatus(HttpStatus status) {
				this.status = status;
			}

			public String getMessage() {
				return message;
			}

			public void setMessage(String message) {
				this.message = message;
			}

			public List<String> getErrors() {
				return errors;
			}

			public void setErrors(List<String> errors) {
				this.errors = errors;
			}
			
		}
}
