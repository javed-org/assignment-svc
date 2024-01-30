package org.mus.demodevops.entity;

import jakarta.persistence.*;

/**
 * @author Usman
 * @created 1/23/2024 - 5:40 PM
 * @project demo-devops
 */

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@Column(name = "uuid") private String uuid;
	@Column(name = "mobileNumber") String mobileNumber;
	@Column(name = "first_name") private String firstName;
	@Column(name = "last_name") private String lastName;

}
