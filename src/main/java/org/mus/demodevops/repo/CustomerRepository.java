package org.mus.demodevops.repo;

import org.mus.demodevops.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Usman
 * @created 1/23/2024 - 5:39 PM
 * @project demo-devops
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByUuid(String uuid);
}
