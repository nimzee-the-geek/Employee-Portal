/**
 * 
 */
package com.socgen.employeeportal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.socgen.employeeportal.dao.EmployeePortalRepository;
import com.socgen.employeeportal.model.Employee;



/**
 * @author Nimesh t
 *
 */
public class EmployeePortalServiceTest {
	
	@InjectMocks
	private EmployeePortalServiceImpl empPortalService;
	
	@Mock
	private EmployeePortalRepository empPortalRepository;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Getting all employees with first name in ascending order")
	public void testGetAllEmployeesByFirstName_OrdAsc(){
		when(empPortalRepository.findByOrderByFirstNameAsc()).thenReturn(Stream.of(
				new Employee("UUID01","Berty","Rhodes","Female",Calendar.getInstance().getTime(),"Technology"),
				new Employee("UUID02","Mark","Rhodes","Male",Calendar.getInstance().getTime(),"Technology"))
				.collect(Collectors.toList()));
		
		assertEquals(2, empPortalService.getAllEmployeeDetails().size());
		
		verify(empPortalRepository, times(1)).findByOrderByFirstNameAsc();
		
	}
	
	@Test
	@DisplayName("Saving new employee")
	public void testRegisterEmployee_SaveInvoked(){
		
		final String expectedEmployeeId = "UUID01";
		
		Employee savedEmployee = new Employee();
		savedEmployee.setEmployeeId(expectedEmployeeId);
		savedEmployee.setFirstName("Berty");
		savedEmployee.setLastName("Rhodes");
		savedEmployee.setDepartment("Technology");
		savedEmployee.setGender("Female");
		savedEmployee.setDateOfBirth(Calendar.getInstance().getTime());
		
		when(empPortalRepository.save(any(Employee.class))).thenReturn(savedEmployee);
		
		String actualEmployeeId = empPortalService.registerEmployee(savedEmployee);
		
		assertEquals(expectedEmployeeId, actualEmployeeId);
		
		verify(empPortalRepository, times(1)).save(any(Employee.class));
		
	}
}
