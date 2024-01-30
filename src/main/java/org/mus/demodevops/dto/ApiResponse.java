package org.mus.demodevops.dto;

/**
 * @author Usman
 * @created 1/23/2024 - 5:53 PM
 * @project demo-devops
 */

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class ApiResponse<T> {

	private T Data;
	private String error;
}
