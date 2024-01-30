package org.mus.demodevops.service;

import org.apache.logging.log4j.util.Strings;
import org.mus.demodevops.dto.CustomerDto;
import org.mus.demodevops.entity.Customer;
import org.mus.demodevops.exception.ApplicationException;
import org.mus.demodevops.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Usman
 * @created 1/23/2024 - 5:38 PM
 * @project demo-devops
 */
@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerDto getCustomerByUuid(String uuid) {
		return customerRepository.findByUuid(uuid).map(this::toDto).orElseThrow(() -> new ApplicationException("Unable to find any customer"));
	}
	public List<CustomerDto> getAllCustomers() {
		return customerRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

	}

	public String createCustomer(CustomerDto customer) {
		return Optional.ofNullable(customer)
			.filter(customer1 -> Strings.isNotBlank(customer1.getMobileNumber()))
			.filter(customer1 -> Strings.isNotBlank(customer1.getFirstName()))
			.map(this::toCustomer)
			.map(customer1 -> {
				customer1.setUuid(UUID.randomUUID().toString());
				return customerRepository.save(customer1);
			})
			.map(Customer::getUuid)
			.orElseThrow(() -> new ApplicationException("Unable to create customer."));
	}


	private Customer toCustomer(CustomerDto customerDto){
		return Customer.builder()
	    		.uuid(UUID.randomUUID().toString())
	    		.mobileNumber(customerDto.getMobileNumber())
	    		.firstName(customerDto.getFirstName())
	    		.lastName(customerDto.getLastName())
	    		.build();
	}

	private CustomerDto toDto(Customer customer){
		return CustomerDto.builder()
	    		.uuid(customer.getUuid())
	    		.mobileNumber(customer.getMobileNumber())
	    		.firstName(customer.getFirstName())
	    		.lastName(customer.getLastName())
	    		.build();


	}

}
