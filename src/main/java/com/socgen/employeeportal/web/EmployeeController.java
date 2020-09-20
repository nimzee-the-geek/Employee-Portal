/**
 * 
 */
package com.socgen.employeeportal.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
	@PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerEmployee(@RequestBody Employee employee){
		
		LOGGER.info("Inside registerEmployee method of EmployeeController");
		
		String empId = employeeService.registerEmployee(employee);
		
		return new ResponseEntity<>(empId, HttpStatus.OK);
		
	}
	
	/**
	 * API end point to get all employees from the system
	 * @return List of employees
	 */
	@GetMapping(value="/employees")
	public ResponseEntity<Object> getEmployeeDetails(){	
		
		LOGGER.info("Inside getEmployeeDetails method of EmployeeController");
		
		List<Employee> employees = employeeService.getAllEmployeeDetails();
		
		if(CollectionUtils.isEmpty(employees)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
}
