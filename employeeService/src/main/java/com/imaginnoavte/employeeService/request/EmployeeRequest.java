package com.imaginnoavte.employeeService.request;

import java.util.Date;
import java.util.List;

import com.imaginnoavte.employeeService.entity.MobileEntity;

import lombok.Data;

@Data
public class EmployeeRequest {

	public Integer eid;
	public String firstName;
	public String lastName;
	public String email;
	public Date doj;
	public Double salary;
	public List<MobileEntity> mobileNum;
}
