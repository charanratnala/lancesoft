package com.lhs.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lhs.dao.RegistrationRepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;
import com.lhs.restcontroller.RegistrationController;
import com.lhs.service.RegistrationService;
@SpringBootTest
class RegistrationControllerTest2 {

	@Autowired
	RegistrationRepo rep;
	
	
      @Mock
      RegistrationService registrationService;
      
      
      
      @InjectMocks
      RegistrationController controller;
	
	
	@Test
	public void testRegister() {
		
		
		RegistrationEntity entity = new RegistrationEntity();
		
		entity.setFirstname("charan");
		entity.setUsername("saicharan");
		entity.setPassword("saicharan");
		entity.setGender("male");
		entity.setDob("02-05-1998");
		entity.setMobileno(949494165);
		entity.setRolen("USER");
		entity.setRole(new ArrayList());
		entity.setId(1);
		
		rep.save(entity);
		
	}
	
	
	
	@Test
	void testEntity()
	{
RegistrationEntity entity = new RegistrationEntity();
		
		entity.setFirstname("charan");
		entity.setUsername("saicharan");
		entity.setPassword("saicharan");
		entity.setGender("male");
		entity.setDob("02-05-1998");
		entity.setMobileno(949494165);
		entity.setRolen("USER");
		entity.setRole(new ArrayList());
		entity.setId(1);
	}
	
	
	
	
	
	
	
	
	@Test
	public void testAddRegister()
	{
		RegistrationDto entity= new RegistrationDto();
		entity.setFirstname("charan");
		entity.setUsername("saicharan");
		entity.setPassword("saicharan");
		entity.setGender("male");
		entity.setDob("02-05-1998");
		entity.setMobileno(949494165);
		entity.setRolen("USER");
		entity.setRole(new ArrayList());

		
		
		
		when(registrationService.addAccount(entity)).thenReturn(entity);
		
	ResponseEntity<String> e=	controller.addRegistration(entity);
		assertEquals(HttpStatus.OK, e.getStatusCode());
		
		
		
		
	}
	
	
	@Test
	public void testAddRegister1()
	{
		RegistrationDto entity= new RegistrationDto();
		entity.setFirstname("charan");
		entity.setUsername("saicharan");
		entity.setPassword("saicharan");
		entity.setGender("male");
		entity.setDob("02-05-1998");
		entity.setMobileno(949494165);
		entity.setRolen("USER");
		entity.setRole(new ArrayList());

		
		
		
		when(registrationService.addAccount(entity)).thenReturn(entity);
		
	ResponseEntity<String> e=	controller.addRegistration(entity);
		assertEquals(HttpStatus.OK, e.getStatusCode());
		Assertions.assertThat(entity.getUsername());
		
		
		
		
	}
	
	
	
	
	

}
