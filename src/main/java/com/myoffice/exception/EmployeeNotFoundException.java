package com.myoffice.exception;

/**
 * EmployeeNotFoundException - handle the employee not found exception in this custom
 * exception class
 * 
 * @author Govindasamy.C
 * @version V1.1
 * @since 15-02-2020
 *
 */
public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
