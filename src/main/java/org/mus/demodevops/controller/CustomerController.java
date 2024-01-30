package org.mus.demodevops.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mus.demodevops.dto.ApiResponse;
import org.mus.demodevops.dto.CustomerDto;
import org.mus.demodevops.entity.Customer;
import org.mus.demodevops.service.CustomerService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Usman
 * @created 1/23/2024 - 5:36 PM
 * @project demo-devops
 */

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {


	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(path = "/{uuid}")
	public ResponseEntity<ApiResponse<CustomerDto>> getCustomerByUuid(@PathVariable String uuid){
		return ResponseEntity.ok(new ApiResponse<>(customerService.getCustomerByUuid(uuid), null));
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<CustomerDto>>> getAllCustomer(){
		return ResponseEntity.ok(new ApiResponse<>(customerService.getAllCustomers(), null));
	}

	@PostMapping
	public ResponseEntity<ApiResponse<String>> getAllCustomer(@RequestBody CustomerDto customer){
		return ResponseEntity.ok(new ApiResponse<>(customerService.createCustomer(customer), null));
	}



}
