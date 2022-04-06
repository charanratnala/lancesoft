package com.lhs.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lhs.entity.RegistrationEntity;
@SpringBootTest
class RegistrationRepoTest2 {
	
	@Autowired
	RegistrationRepo registrationRepo;

	@Test
	void testRegistrationRepo() {
		
		
		
		
		RegistrationEntity entity= new RegistrationEntity();
		entity.setId(1);
		entity.setFirstname("charan");
		entity.setPassword("Charan1656");
		entity.setUsername("saicharan");
		
		registrationRepo.save(entity);
		
		
		
		
		
		
	}

}
