package com.imaginnoavte.employeeService.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "imginnovate", name = "employee")
public class EmpEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	public Integer empId;
	@Column(name = "first_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "e_mail")
	public String eMail;
	@Column(name = "doj")
	public Date doj;
	@Column(name = "salary")
	public Double salary;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_mobs", referencedColumnName = "emp_id")
	public List<MobileEntity> mobileNum;
}
