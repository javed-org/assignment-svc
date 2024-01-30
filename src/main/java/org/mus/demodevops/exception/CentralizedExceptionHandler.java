package org.mus.demodevops.exception;

import org.mus.demodevops.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Usman
 * @created 1/23/2024 - 5:52 PM
 * @project demo-devops
 */

@ControllerAdvice
public class CentralizedExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApiResponse<Void>> handleApplicationException(ApplicationException ex){
		ApiResponse<Void> voidApiResponse = new ApiResponse<>(null, ex.getMessage());
		return ResponseEntity.badRequest().body(voidApiResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleApplicationException(Exception ex){
		ApiResponse<Void> voidApiResponse = new ApiResponse<>(null, ex.getMessage());
		return ResponseEntity.badRequest().body(voidApiResponse);
	}


}
