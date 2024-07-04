package com.imaginnoavte.employeeService.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imaginnoavte.employeeService.entity.EmpEntity;
import com.imaginnoavte.employeeService.response.EmpResponse;

@Repository
public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {

	@Query(value="WITH total_salary AS (SELECT eid,CONCAT(first_name, ' ', last_name) AS fullName, salary, CASE WHEN doj > '2024-04-30'\r\n"
			+ " THEN salary - 30000 ELSE salary END AS totalSalary, CASE WHEN salary <= 2500000 THEN 0 WHEN salary BETWEEN 2500000 AND 5000000 \r\n"
			+ " THEN salary * 0.05 + salary * 0.02 WHEN salary BETWEEN 5000000 AND 10000000 THEN salary * 0.1 + salary * 0.02 \r\n"
			+ " ELSE salary * 0.2 + salary * 0.02 END AS tax, CURRENT_TIMESTAMP AS doj FROM amq.employee WHERE doj < CURRENT_TIMESTAMP)\r\n"
			+ "SELECT eid, fullName, salary, tax, totalSalary, CASE WHEN totalSalary > 0 THEN totalSalary ELSE salary END AS totalSalaryWithMonths,\r\n"
			+ "CASE WHEN totalSalary BETWEEN 2500000 AND 5000000 THEN totalSalary * 0.02 ELSE 0 END AS cess, salary / 30 AS lossOfPayPerDay\r\n"
			+ "FROM total_salary WHERE eid = :eid;",nativeQuery = true)
		public EmpResponse myresponse(int eid);
}