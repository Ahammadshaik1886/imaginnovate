package com.imaginnoavte.employeeService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnoavte.employeeService.entity.EmpEntity;
import com.imaginnoavte.employeeService.request.EmployeeRequest;
import com.imaginnoavte.employeeService.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("saveemployee")
	public ResponseEntity<String> saveemployee(@RequestBody EmployeeRequest empRequest) 
	{
		 return ResponseEntity.ok().body(empService.saveEmployee(empRequest));
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<EmpEntity>> getallEmps() 
	{
		 return ResponseEntity.ok().body(empService.getallEmps());
	}
	
	@GetMapping("getdetails/{id}")
	public ResponseEntity<Optional<EmpEntity>> getdetailsById(@PathVariable ("id")Integer id ) 
	{
		 return ResponseEntity.ok().body(empService.getmyResponse(id));
	}
	
}
