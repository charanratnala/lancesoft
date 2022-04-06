//package com.lhs.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.lhs.dao.RegistrationRepo;
//import com.lhs.entity.RegistrationDto;
//import com.lhs.entity.RegistrationEntity;
//import com.lhs.service.RegistrationService;
//@SpringBootTest (classes= {RegistrationControllerTest.class})
//class RegistrationControllerTest {
//
//	@Mock
//	RegistrationService service;
//	
//	
//	@InjectMocks
//	RegistrationController controller;
//	
//	
//	@Test
//	void testRegistrationController() {
//	
//		RegistrationDto dto  = new RegistrationDto();
//		
//		
//		dto.setFirstname("chran");
//		dto.setGender("male");
//		dto.setUsername("charannaidu");
//		dto.setPassword("charan1656");
//		
//		when(service.addAccount(dto)).thenReturn(dto);
//		
//		
//		ResponseEntity<String> res=	controller.addRegistration(dto);
//		
//		assertEquals(HttpStatus.OK,res.getStatusCode());
//		
//		assertEquals(dto.getUsername(),res.getBody().getClass());
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//	
//	@Autowired
//	RegistrationRepo registrationRepo;
//
//	@Test
//	void testRegistrationRepo() {
//		
//		
//		
//		
//		RegistrationEntity entity= new RegistrationEntity(1,"charan","charan","charan");
//	
//		
//		registrationRepo.save(entity);
//		
//		
//		
//		
//		
//		
//	}
//
//
//}
