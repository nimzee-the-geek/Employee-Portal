/**
 * 
 */
package com.socgen.employeeportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Nimesh Thacker
 * This class is a model class for the Employee object.
 * 
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -991486508856268398L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name="ID")
	private String employeeId;
	
	/*First Name of the employee*/
	@Column(name = "FIRST_NAME", length = 30, nullable = false)
	private String firstName;
	
	/*Last Name of the employee*/
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;
	
	/*Gender of the employee*/
	@Column(name = "GENDER", length = 10)
	private String gender;
	
	/*Date of birth of the employee*/
	@Column(name = "BIRTH_DATE")
	private Date dateOfBirth;
	
	/*Department of the employee*/
	@Column(name = "DEPARTMENT", length = 50)
	private String department;
	
	/*Default Employee Constructor*/
	public Employee(){}	
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dateOfBirth
	 * @param department
	 */
	public Employee(String employeeId, String firstName, String lastName, String gender, Date dateOfBirth, String department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}


	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}


	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString(){
		return "Employee[" +
			"First Name: "+ firstName +
			"Last Name: " + lastName +
			"Gender: "+ gender +
			"dateOfBirth: " + dateOfBirth +
			"Department: " + department + "]";
	}
	

}

