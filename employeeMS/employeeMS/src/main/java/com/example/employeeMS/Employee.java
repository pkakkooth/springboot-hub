package com.example.employeeMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
public Employee() {
		super();
	}
@Id
@Column(name = "EMP_ID")
private Integer empId;

@Column(name = "EMP_SALARY")
private Double empSalary;
@Column(name = "EMP_NAME")
private String empName;
@Column(name = "EMP_JOB")
private String empJob;
@Column(name="EMP_DEPARTMENT")
private String empDepartment;

public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public Double getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(Double empSalary) {
	this.empSalary = empSalary;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpJob() {
	return empJob;
}
public void setEmpJob(String empJob) {
	this.empJob = empJob;
}
public String getEmpDepartment() {
	return empDepartment;
}
public void setEmpDepartment(String empDepartment) {
	this.empDepartment = empDepartment;
}
}
