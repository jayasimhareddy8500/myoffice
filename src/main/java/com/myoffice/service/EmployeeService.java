package com.myoffice.service;

import javax.validation.Valid;

import com.myoffice.dto.LoginRequestDto;
import com.myoffice.dto.LoginResponseDto;
import com.myoffice.dto.RegistrationRequestDto;
import com.myoffice.dto.RegistrationResponceDto;
import com.myoffice.exception.UserNotFoundException;

public interface EmployeeService {

	RegistrationResponceDto empRegistartion(@Valid RegistrationRequestDto registrationRequestDto);

	LoginResponseDto authenticateEmployee(@Valid LoginRequestDto loginRequestDto)throws UserNotFoundException;


}
