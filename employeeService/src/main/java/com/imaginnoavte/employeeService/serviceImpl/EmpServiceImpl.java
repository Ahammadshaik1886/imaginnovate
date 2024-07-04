package com.imaginnoavte.employeeService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnoavte.employeeService.entity.EmpEntity;
import com.imaginnoavte.employeeService.entity.MobileEntity;
import com.imaginnoavte.employeeService.repos.EmpRepo;
import com.imaginnoavte.employeeService.request.EmployeeRequest;
import com.imaginnoavte.employeeService.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepo employeeRepo;

	public String saveEmployee(EmployeeRequest empRequest) {
		try {
			EmpEntity employeeEntity = new EmpEntity();

			List<MobileEntity> mobileNums = empRequest.getMobileNum();
			for (MobileEntity mobiles : mobileNums) {
				mobiles.setMNum(mobiles.getMNum());
			}
			employeeEntity.setDoj(empRequest.getDoj());
			employeeEntity.setEMail(empRequest.getEmail());
			employeeEntity.setFirstName(empRequest.getFirstName());
			employeeEntity.setLastName(empRequest.getLastName());
			employeeEntity.setSalary(empRequest.getSalary());
			employeeEntity.setMobileNum(mobileNums);

			employeeRepo.save(employeeEntity);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public List<EmpEntity> getallEmps() {
		List<EmpEntity> EmployeeEntity = employeeRepo.findAll();
		return EmployeeEntity;
	}

	public Optional<EmpEntity> getmyResponse(int id) {
		Optional<EmpEntity> getmyResponse = employeeRepo.findById(id);
		return getmyResponse;
	}

	public String deletemyResponse(int id) {
		employeeRepo.deleteById(id);
		return "delete success";
	}
}
