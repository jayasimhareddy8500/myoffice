package com.myoffice.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myoffice.constant.AppConstant;
import com.myoffice.dto.LoginRequestDto;
import com.myoffice.dto.LoginResponseDto;
import com.myoffice.dto.RegistrationRequestDto;
import com.myoffice.dto.RegistrationResponceDto;
import com.myoffice.entity.Employee;
import com.myoffice.exception.UserNotFoundException;
import com.myoffice.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	Employee employee = new Employee();

	@Override
	public RegistrationResponceDto empRegistartion(@Valid RegistrationRequestDto registrationRequestDto) {
		RegistrationResponceDto registrationResponceDto = new RegistrationResponceDto();
		employee.setEmployeeName(registrationRequestDto.getEmployeeName());
		employee.setEmailAddress(registrationRequestDto.getEmailAddress());
		employee.setDateOfJoining(registrationRequestDto.getDateOfJoining());
		employee.setDob(registrationRequestDto.getDob());
		employee.setPhoneNumber(registrationRequestDto.getPhoneNumber());
		employee.setYearsOfExperience(registrationRequestDto.getYearsOfExperience());
		employee.setDesignation(registrationRequestDto.getDesignation());
		Employee response = employeeRepository.save(employee);

		BeanUtils.copyProperties(response, registrationResponceDto);
		return registrationResponceDto;

	}

	@Override
	public LoginResponseDto authenticateEmployee(LoginRequestDto loginRequestDto) throws UserNotFoundException {

		Optional<Employee> user = employeeRepository.findByPhoneNumberAndPassword(loginRequestDto.getPhoneNumber(),
				loginRequestDto.getPassword());

		LoginResponseDto loginResponseDto = new LoginResponseDto();

		if (user.isPresent()) {
			BeanUtils.copyProperties(user.get(), loginResponseDto);
			loginResponseDto.setEmployeename(loginResponseDto.getEmployeename());

			loginResponseDto.setEmployeeId(loginResponseDto.getEmployeeId());

			loginResponseDto.setMessage(AppConstant.LOGIN_SCCUESS_MESSAGE);

			loginResponseDto.setStatusCode(AppConstant.SUCCESS_STATUS_CODE);

			log.info("UserServiceImpl authenticateUser ---> user signed in");
			return loginResponseDto;
		} else {
			log.error("UserServiceImpl authenticateUser ---> NotFoundException occured");
			throw new UserNotFoundException(AppConstant.USER_NOT_FOUND);
		}

	}

}
