package com.myoffice.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.myoffice.common.MyOfficeEnum.Role;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Amala.S
 * @version V1.1
 * @since 15-02-2020
 *
 */
@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String employeeName;
	private String emailAddress;
	private LocalDate dob;
	private LocalDate dateOfJoining;
	private Integer sapId;
	@Enumerated(EnumType.STRING)
	private Role role;
}
