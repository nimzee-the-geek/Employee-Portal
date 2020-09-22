/**
 * 
 */
package com.socgen.employeeportal.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.employeeportal.model.Employee;
import com.socgen.employeeportal.service.EmployeePortalService;

/**
 * @author Nimesh
 * Test class for Employee Portal Controller
 *
 */
public class EmployeePortalControllerTest {
	
	@InjectMocks
	private EmployeeController empController;
	
	@Mock
	private EmployeePortalService empService;

	private MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
	}
	
	@Test
	@DisplayName("Registering New Employee")
	public void testSaveValidEmployee_Return200OK() throws Exception{
		
		Employee employee = getEmployeeDetails();
		String empId = employee.getEmployeeId();
		
		final String employeeJson = om.writeValueAsString(employee);
		
		when(empService.registerEmployee(any(Employee.class))).thenReturn(empId);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/EmployeeService/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeeJson).accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", is(empId))).andDo(print());

	}
	
	@Test
	@DisplayName("Getting All Employees")
	public void testGetAllEmployees_Return200OK() throws Exception{
		
		Employee employee = getEmployeeDetails();
		
		List<Employee> empList = new ArrayList<>();
		empList.add(employee);
		
		when(empService.getAllEmployeeDetails()).thenReturn(empList);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/EmployeeService/employees");
				
		
		mockMvc.perform(request).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].employeeId", is(employee.getEmployeeId())))
		.andExpect(jsonPath("$[0].firstName", is(employee.getFirstName())))
		.andExpect(jsonPath("$[0].lastName", is(employee.getLastName())))
		.andExpect(jsonPath("$[0].department", is(employee.getDepartment())))
		.andExpect(jsonPath("$[0].gender", is(employee.getGender())))
		.andExpect(jsonPath("$[0].dateOfBirth", is(employee.getDateOfBirth().getTime())))
		.andDo(print());
		
		verify(empService, times(1)).getAllEmployeeDetails();

	}
	
	@Test
	@DisplayName("Getting All Employees - Empty Result")
	public void testGetAllEmployees_NoContent() throws Exception{
		
		when(empService.getAllEmployeeDetails()).thenReturn(Collections.emptyList());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/EmployeeService/employees"))
		.andExpect(status().isNoContent());
		
		verify(empService, times(1)).getAllEmployeeDetails();
	}
	
	
	private Employee getEmployeeDetails() {
		
		final String empId = "UUID01";		
		
		Employee employee = new Employee();
		employee.setEmployeeId(empId);
		employee.setFirstName("Jack");
		employee.setLastName("Wilder");
		employee.setDepartment("Sales");
		employee.setGender("Male");
		Calendar myCalendar = new GregorianCalendar(1984, 2, 11);
		Date myDate = myCalendar.getTime();
		employee.setDateOfBirth(myDate);
		
		return employee;
	}
		
}
