package com.raghav.DAO;

import java.util.List;

import com.raghav.company.Employee;
import com.raghav.company.Phone;

public interface EmployeeDAO {

	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployeeOnID(long ID);
	public List<Employee> getEmployees();
	public Phone addPhone(Phone phone);
}
