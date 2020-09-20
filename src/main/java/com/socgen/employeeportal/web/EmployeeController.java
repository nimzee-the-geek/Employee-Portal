/**
 * 
 */
package com.socgen.employeeportal.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.employeeportal.model.Employee;
import com.socgen.employeeportal.service.EmployeePortalService;



/**
 * @author Nimesh
 * Rest end points for the users to consume for the Employee Portal application
 *
 */
@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeePortalService employeeService;
	
	/**
	 * API end point to register new employee to the system
	 * @param employee
	 */
	@PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void registerEmployee(@RequestBody Employee employee){
		
		LOGGER.info("Inside registerEmployee method of EmployeeController");
		
		employeeService.registerEmployee(employee);
		
	}
	
	/**
	 * API end point to get all employees from the system
	 * @return List of employees
	 */
	@GetMapping(value="/employees")
	public List<Employee> getEmployeeDetails(){	
		
		LOGGER.info("Inside getEmployeeDetails method of EmployeeController");
		
		return employeeService.getAllEmployeeDetails();
	}
	
}
