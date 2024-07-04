package com.imaginnoavte.employeeService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imaginnoavte.employeeService.entity.EmpEntity;
import com.imaginnoavte.employeeService.request.EmployeeRequest;

@Service
public interface EmpService {

	public String saveEmployee(EmployeeRequest empRequest);

	public List<EmpEntity> getallEmps();

	public Optional<EmpEntity> getmyResponse(int id);
}
