/**
 * 
 */
package com.socgen.employeeportal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.employeeportal.dao.EmployeePortalRepository;
import com.socgen.employeeportal.exception.PortalServiceException;
import com.socgen.employeeportal.model.Employee;

/**
 * @author Nimesh
 * Service implementation class for connecting with the database repository	
 */
@Service
public class EmployeePortalServiceImpl implements EmployeePortalService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePortalServiceImpl.class);
	
	@Autowired
	private EmployeePortalRepository employeeRepository;
	
	/**
	 * This method register a new employee in to the system.
	 * @return - returns the generated employee id
	 */
	@Override
	public String registerEmployee(Employee employee) {
		
		try {
			Employee emp = employeeRepository.save(employee);
			
			LOGGER.info("Registered employee with employee id: {}", emp.getEmployeeId());
			
			return emp.getEmployeeId();
		}
		catch(Exception exception) {
			throw new PortalServiceException(exception.getMessage(), exception.getCause());
		}
	}
	
	/**
	 * This method returns the list of all the employees in the system
	 * Order by First Name ascending
	 * @return List of employee objects
	 */
	@Override
	public List<Employee> getAllEmployeeDetails() {
		
		try {
			
			List<Employee> employees =  new ArrayList<>();		
			employeeRepository.findByOrderByFirstNameAsc().forEach(employees::add);

			LOGGER.info("Fetching list of employees of size: {}", employees.size());
			
			return employees;
		}
		catch(Exception exception) {
			throw new PortalServiceException(exception.getMessage(), exception.getCause());
		}
		
	}
	
}
