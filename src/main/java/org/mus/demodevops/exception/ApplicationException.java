package org.mus.demodevops.exception;

/**
 * @author Usman
 * @created 1/23/2024 - 5:47 PM
 * @project demo-devops
 */
public class ApplicationException extends RuntimeException {
	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}
}
