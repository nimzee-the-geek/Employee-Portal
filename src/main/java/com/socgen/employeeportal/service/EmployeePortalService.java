/**
 * 
 */
package com.socgen.employeeportal.service;

import java.util.List;

import com.socgen.employeeportal.model.Employee;

/**
 * @author Nimesh
 * Service interface for the Employee Portal application
 */
public interface EmployeePortalService {
	
	/*Registers a new employee into the system*/
	public String registerEmployee(Employee employee);
	
	/*Returns the list of employees*/
	public List<Employee> getAllEmployeeDetails();
}
