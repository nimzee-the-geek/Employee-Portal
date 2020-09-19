/**
 * 
 */
package com.socgen.employeeportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.employeeportal.dao.EmployeePortalRepository;
import com.socgen.employeeportal.model.Employee;

/**
 * @author Nimesh
 * Service implementation class for connecting with the database repository	
 */
@Service
public class EmployeePortalServiceImpl implements EmployeePortalService {
	
	@Autowired
	private EmployeePortalRepository employeeRepository;
	
	/**
	 * This method register a new employee in to the system.
	 * @return - returns the generated employee id
	 */
	@Override
	public String registerEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
		return emp.getEmployeeId();
	}
	
	/**
	 * This method returns the list of all the employees in the system
	 * Order by First Name ascending
	 * @return List of employee objects
	 */
	@Override
	public List<Employee> getAllEmployeeDetails() {
		
		List<Employee> employees =  new ArrayList<>();		
		employeeRepository.findByOrderByFirstNameAsc().forEach(employees::add);
		
		return employees;
	}
	
}
