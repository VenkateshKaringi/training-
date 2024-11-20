package com.vk.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name ="emps")
public class Employee { 
	
		@Id
		@Column(name ="emp_no")
		private int empNo;
		@Pattern(regexp ="^[A-Z]{1}[a-z]$" ,message = "name should start with a capital letter")
//		@Column(name ="ename",length = 30)
		private String empName;
		@Column(length =20)
		private String job;
		@Min(value = 100, message = " salary minimum should be 100")
		@Max (value = 9000, message = "salary maximum should be 9000 only")
		private double salary;
		@Column(name ="hire_date")
		private LocalDate hireDate;
		
		
		// constructor
		public Employee() {
		}
		//parameterized constructor
		public Employee(int empNo, String empName, String job, double salary, LocalDate hireDate) {
			super();
			this.empNo = empNo;
			this.empName = empName;
			this.job = job;
			this.salary = salary;
			this.hireDate = hireDate;
		}
		//setter and getters
		public int getEmpNo() {
			return empNo;
		}

		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public LocalDate getHireDate() {
			return hireDate;
		}

		public void setHireDate(LocalDate hireDate) {
			this.hireDate = hireDate;
		}
}
