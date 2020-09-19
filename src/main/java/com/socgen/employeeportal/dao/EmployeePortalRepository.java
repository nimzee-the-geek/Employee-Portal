/**
 * 
 */
package com.socgen.employeeportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socgen.employeeportal.model.Employee;


/**
 * @author Nimesh
 * This class is used to connect the application code with APIs which 
 * are part of JPA repository directly with database
 *
 */
public interface EmployeePortalRepository extends JpaRepository<Employee, String>{
	
	/**
	 * This method returns list of employees available
	 * in the database order by First Name ascending
	 * @return List<Employee>
	 */
	public List<Employee> findByOrderByFirstNameAsc();
	
}
