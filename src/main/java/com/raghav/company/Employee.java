package com.raghav.company;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private long Emp_ID;
	private String FirstName;
	private String LastName;
	private double Salary;
	private int Manager_ID;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Phone> phones;
	
	public long getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(long emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public int getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(int manager_ID) {
		Manager_ID = manager_ID;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
	

}
