package com.lhs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lhs.dao.RegistrationRepo;
import com.lhs.dao.Rolerepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;

@SpringBootTest
class RegistrationServiceTest {

	
	@Mock
	RegistrationRepo registrationRepo;
	
	@Mock
	Rolerepo rolerepo;
	
	
	@InjectMocks
	RegistrationService registrationService;
	
	
	
	@Test
	void testAddaccountService() {
		RegistrationDto dto = new RegistrationDto();
		dto.setFirstname("charan");
		dto.setPassword("Charan1656");
		dto.setUsername("charans");
		dto.setRolen("USER");
		RegistrationEntity entity= new RegistrationEntity();
		entity.setId(1);
		entity.setFirstname("charan");
		entity.setPassword("Charan1656");
		entity.setUsername("charans");
		entity.setRolen("USER");
		
		when(registrationRepo.save(entity)).thenReturn(entity);
		
		RegistrationDto serv=	registrationService.addAccount(dto);
		assertEquals(dto.getUsername(),serv.getUsername());
		
		assertFalse(registrationRepo.existsByUsername(dto.getUsername()));
//assertThrows(GlobalExceptionHandler.class, ()->{
//	
//	registrationService.addAccount(dto);
//});
//		
//		
		
		
	}



	
}
