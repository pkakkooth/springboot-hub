package com.example.employeeMS;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;

	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees(){
	return repository.findAll();
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId")Integer employeeId){
	//Check if employee exists in database for given employeeId
	Optional<Employee> data = repository.findById(employeeId);
	if(data.isPresent()) {
	ResponseEntity<Employee> response = new ResponseEntity(data.get(), HttpStatus.OK);
	return response;
	}else {
	ResponseEntity<Employee> response = new ResponseEntity(data.get(), HttpStatus.NOT_FOUND);
	return response;
	}
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp){
	try {
	repository.save(emp);
	ResponseEntity<String> response = new ResponseEntity<>("Employee Created", HttpStatus.CREATED);
	return response;
	} catch (Exception e) {
	ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	return response;
	}
	}

}

