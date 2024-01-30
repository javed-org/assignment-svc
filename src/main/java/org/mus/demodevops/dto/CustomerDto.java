package org.mus.demodevops.dto;

/**
 * @author Usman
 * @created 1/23/2024 - 5:37 PM
 * @project demo-devops
 */

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class CustomerDto {

	private String uuid;
	private String mobileNumber;
	private String firstName;
	private String lastName;


}
